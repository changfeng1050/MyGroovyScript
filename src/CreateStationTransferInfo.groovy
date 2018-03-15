import com.google.gson.GsonBuilder
import groovy.json.JsonBuilder
import org.jsoup.Jsoup

def jsonBuilder = new JsonBuilder()

def routeUrl = "http://hefei.8684.cn/z_8897929b" // 合肥公交龙居山庄站

def stationInfoList = []

class Line {
    String Id
    String Name

    Line(id, name) {
        Id = id
        Name = name
    }
}

class StationTransferResult {
    String Result
    List<Line> LineList
}


Jsoup.connect(routeUrl).get().select("a.bus_i_span").each {

    println it
    def id = it.attr("href").substring(5, 7)
    def routeName = it.text()

    def line = new Line(id, routeName)
    stationInfoList.add(line)

}

def stationTransferResult = new StationTransferResult()
stationTransferResult.Result = "true"
stationTransferResult.LineList = stationInfoList

def gson = new GsonBuilder().serializeNulls().create()

println gson.toJson(stationTransferResult)
