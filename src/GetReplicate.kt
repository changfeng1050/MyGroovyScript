
class GetReplicate {
    fun getReplicate(numberList: List<String>): List<String> {
        return numberList.filter { number -> numberList.count { it == number } > 1 }
    }
}