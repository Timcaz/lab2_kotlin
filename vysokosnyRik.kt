fun isLeapYear(year: Int): Boolean {
    return if (year % 4 == 0) {
        if (year % 100 == 0) {
            year % 400 == 0
        } else {
            true
        }
    } else {
        false
    }
}

fun main() {
    print("Введіть рік: ")
    val input = readLine()

    if (input != null) {
        try {
            val year = input.toInt()
            val isLeap = isLeapYear(year)
            println("$year - високосний? $isLeap")
        } catch (e: NumberFormatException) {
            println("Невірний ввід. Будь ласка, введіть ціле число.")
        }
    } else {
        println("Ввід невірний.")
    }
}