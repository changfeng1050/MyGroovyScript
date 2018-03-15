import com.google.gson.GsonBuilder

import java.text.SimpleDateFormat

def gson = new GsonBuilder().serializeNulls().create()

class PlayTime {

    PlayTime(String start, String end) {
        startTime = start
        endTime = end
    }

    String startTime
    String endTime
}

def timeFormat = new SimpleDateFormat("HH:mm:ss")

def currentTime = System.currentTimeMillis() - 300 * 1000

def timeList = new ArrayList<PlayTime>()

for (int i = 0; i < 120; i++) {
    currentTime += 120000
    PlayTime time = new PlayTime(timeFormat.format(new Date(currentTime)), timeFormat.format(new Date(currentTime + 60000)))
    timeList.add(time)
}


timeList.forEach {
    println gson.toJson(it)
    println ","
}