import org.jsoup.Jsoup

static boolean saveUrlAs(String fileUrl, String savePath)/* fileUrl网络资源地址 */ {

    try {
        /* 将网络资源地址传给,即赋值给url */
        URL url = new URL(fileUrl);

        /* 此为联系获得网络资源的固定格式用法，以便后面的in变量获得url截取网络资源的输入流 */
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        DataInputStream in1 = new DataInputStream(connection.getInputStream());

        /* 此处也可用BufferedInputStream与BufferedOutputStream  需要保存的路径*/
        DataOutputStream out = new DataOutputStream(new FileOutputStream(savePath));

        /* 将参数savePath，即将截取的图片的存储在本地地址赋值给out输出流所指定的地址 */
        byte[] buffer = new byte[4096];
        def count = 0;
        while ((count = in1.read(buffer)) > 0)/* 将输入流以字节的形式读取并写入buffer中 */ {
            out.write(buffer, 0, count);
        }
        out.close();/* 后面三行为关闭输入输出流以及网络资源的固定格式 */
        in1.close();
        connection.disconnect();
        return true;/* 网络资源截取并存储本地成功返回true */

    } catch (Exception e) {
        System.out.println(e + fileUrl + savePath);
        return false;
    }
}

def id = "2332587" // 白云区

// 按小时查看天气
Jsoup.connect("http://m.weathercn.com/hourly-weather-forecast.do?partner=&language=zh-cn&id=${id}&p_source=&p_type=jump").get().select("section.times").each {
    def a = it.select("> ul").first()

    def time = a.select("p").first().text()
    def temperature = a.select("p")[1].text()
    def imageUrls = a.select("img").attr("src1")
    println "$time $temperature"
}

// 当前天气
Jsoup.connect("http://m.weathercn.com/current-weather.do?partner=&language=zh-cn&id=${id}&p_source=&p_type=jump").get().select("section.weather").each {
    def temperature = it.select("p").first().text()
    def texts = it.select("p")[1].text().split(" ")

    println "$temperature ${texts[0]}和${texts[1]}"
}
//
//// 天气图标地址 http://m.weathercn.com//images/real/cma/00.png
//
//def photoUrlPrefix = "http://m.weathercn.com//images/real/cma/"
//
//def photoDir = "E:\\work\\13LCD多媒体信息屏项目\\09 UI设计\\01 天气图标\\00 中国天气网天气现象图标"
//
//for (int i = 0; i < 100; i++) {
//    def fileName = String.format("%02d.png", i)
//    def url = photoUrlPrefix + fileName
//    def localPath = photoDir + File.separator + fileName
//    saveUrlAs(url, localPath)
//    println "文件 $fileName 下载完毕"
//}

