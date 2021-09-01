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

fun agoToText(secondInt: Int): String {
   return when (secondInt) {
        in 0 .. 60 -> return "Был в сети только что"
        in 61 .. 3_600  -> endsWordsMinutes(secondInt)
        in 3601 .. 86_400 -> endsWordsHours(secondInt)
        in 86_401 .. 172_800 -> return "Был в сети сегодня"
        in 172_801 .. 259_200 -> return "Был в сети вчера"
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