def filePath = "E:\\work\\13LCD多媒体信息屏项目\\01 客户\\18 安徽富煌\\06 需求\\"
def fileName = "Vehicles.json"

def lines = new File(filePath + fileName).readLines()

lines.each {
    if (it.contains("VehicleId")) {
        println it
    }
}
