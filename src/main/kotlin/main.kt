private fun endsWordsMinutes(second: Int): String {
     val secondToMinutes = second / 60
     if (secondToMinutes >= 10 && secondToMinutes <= 14) {
         return "Был в сети $secondToMinutes минут назад"
     }else {
         when (secondToMinutes % 10) {
             1 -> return "Был в сети $secondToMinutes минуту назад"
             in 2..4 -> return "Был в сети $secondToMinutes минуты назад"
             else -> return "Был в сети $secondToMinutes минут назад"
         }
     }
}
private fun endsWordsHours(second: Int): String {
    val secondToMinutes = second / 60 / 60
    if (secondToMinutes >= 10 && secondToMinutes <= 14) {
        return "Был в сети $secondToMinutes часов назад"
    }else {
        when (secondToMinutes % 10) {
            1 -> return "Был в сети $secondToMinutes час назад"
            in 2..4 -> return "Был в сети $secondToMinutes часа назад"
            else -> return "Был в сети $secondToMinutes часов назад"
        }
    }
}

private fun agoToText(secondInt: Int): String {
   return when {
        secondInt <= 60 -> return "Был в сети только что"
        secondInt >= 61 && secondInt <= 3600 -> endsWordsMinutes(secondInt)
        secondInt >= 60 * 60 + 1 && secondInt <= 24 * 60 * 60 -> endsWordsHours(secondInt)
        secondInt >= 24 * 60 * 60 + 1 && secondInt <= 2 * 24 * 60 * 60 -> return "Был в сети сегодня"
        secondInt >= 2 * 24 * 60 * 60 + 1 && secondInt <= 3 * 24 * 60 * 60 -> return "Был в сети вчера"
        else -> return "Был в сети давно"
   }
}

fun main() {
    val second = readLine()
    val secondInt = second?.toInt()
    if (secondInt != null) {
        println(agoToText(secondInt))
    }
}