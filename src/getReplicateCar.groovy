def filePath = "E:\\work\\13LCD多媒体信息屏项目\\01 客户\\08 珠海公交\\04 设备信息\\2018-02-12\\"
def fileName = "old.txt"

def fileReader = new FileReader(filePath + fileName)

def lines = fileReader.readLines()

def l = new ArrayList<String>()
lines.each {
    def items = it.split("\\s+")
    l.add(items.first())
}

def replicate = new GetReplicate()

def replicateCars = replicate.getReplicate(l)

replicateCars.each {
    println it
}


