import java.util.regex.Pattern

object Util {
    @JvmStatic
    fun isValidMac(mac: String?): Boolean {
        if (mac == null || mac.isEmpty()) {
            return false
        }
        val macAddressRule = "([A-Fa-f0-9]{2}[-,:]){5}[A-Fa-f0-9]{2}"
        val pattern = Pattern.compile(macAddressRule)
        val mather = pattern.matcher(mac)
        return mather.matches()
    }


}