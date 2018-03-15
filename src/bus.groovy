import org.jsoup.Jsoup

class Transfer {

    Transfer(String name, String detail) {
        this.routeName = name
        this.detail = detail
    }
    String routeName
    String detail

    @Override
    String toString() {
        return """
{
"routeName":"$routeName",
"detail":"$detail"
}
"""
    }
}

def transferInfoList = new ArrayList<Transfer>()

println "中山八路总站"
Jsoup.connect("http://guangzhou.8684.cn/z_2cf2508f").get().select("div.bus_site_top").each {

    def a = it.select("> a").first()
    def startEnd = a.select("span.bus_site_tt2").text()
    def routeName = a.text().replace(startEnd, "")

    startEnd = startEnd.replace("-", "---")
    transferInfoList.add(new Transfer(routeName, startEnd))

}
println """
,
"transferInfos:"
"""
println transferInfoList


println "荔湾路口"
Jsoup.connect("http://guangzhou.8684.cn/z_68ec2834").get().select("div.bus_site_top").each {

    def a = it.select("> a").first()
    def startEnd = a.select("span.bus_site_tt2").text()
    def routeName = a.text().replace(startEnd, "")

    startEnd = startEnd.replace("-", "---")
    transferInfoList.add(new Transfer(routeName, startEnd))

}
println """
,
"transferInfos:"
"""
println transferInfoList


println "陈家祠"
Jsoup.connect("http://guangzhou.8684.cn/z_d82de527").get().select("div.bus_site_top").each {

    def a = it.select("> a").first()
    def startEnd = a.select("span.bus_site_tt2").text()
    def routeName = a.text().replace(startEnd, "")

    startEnd = startEnd.replace("-", "---")
    transferInfoList.add(new Transfer(routeName, startEnd))

}
println """
,
"transferInfos:"
"""
println transferInfoList


println "中山七路"
Jsoup.connect("http://guangzhou.8684.cn/z_4ea0e8e2").get().select("div.bus_site_top").each {

    def a = it.select("> a").first()
    def startEnd = a.select("span.bus_site_tt2").text()
    def routeName = a.text().replace(startEnd, "")

    startEnd = startEnd.replace("-", "---")
    transferInfoList.add(new Transfer(routeName, startEnd))

}
println """
,
"transferInfos:"
"""
println transferInfoList


println "西门口(中山六路)"
Jsoup.connect("http://guangzhou.8684.cn/z_e1c72464").get().select("div.bus_site_top").each {

    def a = it.select("> a").first()
    def startEnd = a.select("span.bus_site_tt2").text()
    def routeName = a.text().replace(startEnd, "")

    startEnd = startEnd.replace("-", "---")
    transferInfoList.add(new Transfer(routeName, startEnd))

}
println """
,
"transferInfos:"
"""
println transferInfoList


println "中山六路"
Jsoup.connect("http://guangzhou.8684.cn/z_55fa3eee").get().select("div.bus_site_top").each {

    def a = it.select("> a").first()
    def startEnd = a.select("span.bus_site_tt2").text()
    def routeName = a.text().replace(startEnd, "")

    startEnd = startEnd.replace("-", "---")
    transferInfoList.add(new Transfer(routeName, startEnd))

}
println """
,
"transferInfos:"
"""
println transferInfoList


println "中山五路"
Jsoup.connect("http://guangzhou.8684.cn/z_b3b86cab").get().select("div.bus_site_top").each {

    def a = it.select("> a").first()
    def startEnd = a.select("span.bus_site_tt2").text()
    def routeName = a.text().replace(startEnd, "")

    startEnd = startEnd.replace("-", "---")
    transferInfoList.add(new Transfer(routeName, startEnd))

}
println """
,
"transferInfos:"
"""
println transferInfoList


println "农讲所"
Jsoup.connect("http://guangzhou.8684.cn/z_5482974e").get().select("div.bus_site_top").each {

    def a = it.select("> a").first()
    def startEnd = a.select("span.bus_site_tt2").text()
    def routeName = a.text().replace(startEnd, "")

    startEnd = startEnd.replace("-", "---")
    transferInfoList.add(new Transfer(routeName, startEnd))

}
println """
,
"transferInfos:"
"""
println transferInfoList


println "大东门(中山三路)"
Jsoup.connect("http://guangzhou.8684.cn/z_fbd002e7").get().select("div.bus_site_top").each {

    def a = it.select("> a").first()
    def startEnd = a.select("span.bus_site_tt2").text()
    def routeName = a.text().replace(startEnd, "")

    startEnd = startEnd.replace("-", "---")
    transferInfoList.add(new Transfer(routeName, startEnd))

}
println """
,
"transferInfos:"
"""
println transferInfoList


println "烈士陵园"
Jsoup.connect("http://guangzhou.8684.cn/z_ebfaedbb").get().select("div.bus_site_top").each {

    def a = it.select("> a").first()
    def startEnd = a.select("span.bus_site_tt2").text()
    def routeName = a.text().replace(startEnd, "")

    startEnd = startEnd.replace("-", "---")
    transferInfoList.add(new Transfer(routeName, startEnd))

}
println """
,
"transferInfos:"
"""
println transferInfoList


println "中山医"
Jsoup.connect("http://guangzhou.8684.cn/z_3e71a978").get().select("div.bus_site_top").each {

    def a = it.select("> a").first()
    def startEnd = a.select("span.bus_site_tt2").text()
    def routeName = a.text().replace(startEnd, "")

    startEnd = startEnd.replace("-", "---")
    transferInfoList.add(new Transfer(routeName, startEnd))

}
println """
,
"transferInfos:"
"""

println transferInfoList


println "农林东"
Jsoup.connect("http://guangzhou.8684.cn/z_121d506b").get().select("div.bus_site_top").each {

    def a = it.select("> a").first()
    def startEnd = a.select("span.bus_site_tt2").text()
    def routeName = a.text().replace(startEnd, "")

    startEnd = startEnd.replace("-", "---")
    transferInfoList.add(new Transfer(routeName, startEnd))

}
println """
,
"transferInfos:"
"""

println transferInfoList


println "梅花村"
Jsoup.connect("http://guangzhou.8684.cn/z_1716e8d4").get().select("div.bus_site_top").each {

    def a = it.select("> a").first()
    def startEnd = a.select("span.bus_site_tt2").text()
    def routeName = a.text().replace(startEnd, "")

    startEnd = startEnd.replace("-", "---")
    transferInfoList.add(new Transfer(routeName, startEnd))

}
println """
,
"transferInfos:"
"""

println transferInfoList


println "杨箕村"
Jsoup.connect("http://guangzhou.8684.cn/z_49b49336").get().select("div.bus_site_top").each {

    def a = it.select("> a").first()
    def startEnd = a.select("span.bus_site_tt2").text()
    def routeName = a.text().replace(startEnd, "")

    startEnd = startEnd.replace("-", "---")
    transferInfoList.add(new Transfer(routeName, startEnd))

}
println """
,
"transferInfos:"
"""

println transferInfoList


println "南方报社"
Jsoup.connect("http://guangzhou.8684.cn/z_fc6a3dd7").get().select("div.bus_site_top").each {

    def a = it.select("> a").first()
    def startEnd = a.select("span.bus_site_tt2").text()
    def routeName = a.text().replace(startEnd, "")

    startEnd = startEnd.replace("-", "---")
    transferInfoList.add(new Transfer(routeName, startEnd))

}
println """
,
"transferInfos:"
"""

println transferInfoList



println "花城大道"
Jsoup.connect("http://guangzhou.8684.cn/z_02459d16").get().select("div.bus_site_top").each {

    def a = it.select("> a").first()
    def startEnd = a.select("span.bus_site_tt2").text()
    def routeName = a.text().replace(startEnd, "")

    startEnd = startEnd.replace("-", "---")
    transferInfoList.add(new Transfer(routeName, startEnd))

}
println """
,
"transferInfos:"
"""

println transferInfoList


println "花城大道(华穗路口)"
Jsoup.connect("http://guangzhou.8684.cn/z_b2bbb347").get().select("div.bus_site_top").each {

    def a = it.select("> a").first()
    def startEnd = a.select("span.bus_site_tt2").text()
    def routeName = a.text().replace(startEnd, "")

    startEnd = startEnd.replace("-", "---")
    transferInfoList.add(new Transfer(routeName, startEnd))

}
println """
,
"transferInfos:"
"""

println transferInfoList


println "花城大道(地铁潭村站)"
Jsoup.connect("http://guangzhou.8684.cn/z_90c79cf2").get().select("div.bus_site_top").each {

    def a = it.select("> a").first()
    def startEnd = a.select("span.bus_site_tt2").text()
    def routeName = a.text().replace(startEnd, "")

    startEnd = startEnd.replace("-", "---")
    transferInfoList.add(new Transfer(routeName, startEnd))

}
println """
,
"transferInfos:"
"""

println transferInfoList