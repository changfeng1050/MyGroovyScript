def filePath = "E:\\work\\13LCD多媒体信息屏项目\\01 客户\\08 珠海公交\\04 设备信息\\"
def fileName = "新车LCD屏物理地址2018-02-12.txt"

def lines = new File(filePath + fileName).readLines("GBK")

class Device {
    String name
    String mac

    Device(name, mac) {
        this.name = name
        this.mac = mac
    }

    @Override
    String toString() {
        return "$name $mac"
    }
}

def l = new ArrayList<Device>()

def unfinishList = new ArrayList<String>()

for (def i = 0; i < lines.size(); ++i) {

    def items = lines[i].split("\\s+")

    def number = (items[0]).replace("粤C", "").trim()


    if (items.size() < 3 || !Util.isValidMac(items[1]) || !Util.isValidMac(items[2])) {
        unfinishList.add(lines[i])
    }

    try {
        def mac = items[1]
        if (!Util.isValidMac(mac)) {
            println ">>>>>>>>> $number 错误的前屏物理地址 $mac"
            unfinishList.add(lines[i])
        }
        l.add(new Device(number + "-前", mac))
    } catch (Exception e1) {
        println "${items[0]} 没有找到前屏地址"
    }

    try {
        def mac = items[2]
        if (!Util.isValidMac(mac)) {
            println ">>>>>>>>>$number 错误的后屏物理地址 $mac"
            unfinishList.add(lines[i])
        }
        l.add(new Device(number + "-后", mac))
    } catch (Exception e) {
        println "${items[0]} 没有找到后屏地址"
    }
}

l.each {
    println it
}
//
def text = l.join("\r\n")

def outPutDir = filePath + File.separator + "导入MAC" + File.separator

def outPutName = outPutDir + "生成的数据表${new Date().format("yyyy-MM-dd-HHmmss")}.txt"

new File(outPutDir).mkdirs()

new File(outPutName).write(text, "GBK")


def unFinishText = unfinishList.join("\r\n")
def outPutUnFinishFileName = outPutDir + File.separator + "未完成或者出错的车辆登记.txt"

new File(outPutUnFinishFileName).write(unFinishText, "GBK")

println "finish! see $outPutName"


