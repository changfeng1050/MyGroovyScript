import com.google.gson.GsonBuilder
import org.jsoup.Jsoup

/**
 * 拉取 8684 上的公交站点，并保存
 */

//def routeUrl = "http://yingkou.8684.cn/x_3dfcd0fb" // 营口公交8路
def routeUrl = "http://shenzhen.8684.cn/x_47807511" // 深圳M359路公交车路线

String routeName

List<String> upNames = new ArrayList<>()

List<String> downNames = new ArrayList<>()


Jsoup.connect(routeUrl).get().select("div.bus_classification").select(".cr_content").each {
//    获取线路名
    routeName = it.select("span.cr_crumbs_txt").text()
    println "线路名 $routeName"
}


def busLineSiteElements = Jsoup.connect(routeUrl).get().select("div.bus_line_site")

busLineSiteElements[0].select("a").each {
    def name = it.text()
    println("station name:$name")
    upNames.add(name)
}
busLineSiteElements[1].select("a").each {
    def name = it.text()
    println("station name:$name")
    downNames.add(name)
}


static def convertStationName(String name) {
    def firstIndex = name.indexOf('︵')
    def secondIndex = name.indexOf('︶')
    if (firstIndex > -1 && secondIndex > firstIndex) {
        def sub = name.substring(firstIndex, secondIndex + 1)
        def result = name.replace(sub, "")
        println "sub:$sub result:$result"
        return result
    }
    return name
}

class Station {
    int index
    int num
    String name

    Station(String name, int index, int num) {
        this.name = name
        this.index = index
        this.num = num
    }

}

class Route {
    String name
    List<Station> upStations
    List<Station> downStations
}

def route = new Route()
route.name = routeName
route.upStations = new ArrayList<>()
route.downStations = new ArrayList<>()

for (int i = 0; i < upNames.size(); i++) {
    String name = convertStationName(upNames[i])
    route.upStations.add(new Station(name, i, i))
}


for (int i = 0; i < downNames.size(); ++i) {
    String name = convertStationName(downNames[i])
    route.downStations.add(new Station(name, i, i))
}

route.upStations.forEach {
    println it.name
}

route.downStations.forEach {
    println it.name
}

def gson = new GsonBuilder().serializeNulls().create()

def routeJson = gson.toJson(route)

def routeDir = "E:\\work\\13LCD多媒体信息屏项目\\05 线路\\" + route.name
def routeFilePath = routeDir + File.separator + "route_data.json"

new File(routeDir).mkdirs()

def file = new File(routeFilePath)
if (!file.exists()) {
    file.createNewFile()
}
file.write(routeJson)

println "保存线路 $routeFilePath"

