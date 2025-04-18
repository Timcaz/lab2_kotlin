class OutOfRangeException(message: String) : Exception(message)
fun validateNumber(number: Int) {
    if (number !in 1..100) {
        throw OutOfRangeException("Число $number не знаходиться в діапазоні 1–100.")
    }
    println("Число $number проходить перевірку.")
}

fun main() {
    val numbersToTest = listOf(50, -10, 150)

    for (num in numbersToTest) {
        try {
            validateNumber(num)
        } catch (e: OutOfRangeException) {
            println("Обробка помилки: ${e.message}")
        }
    }
}
