fun main() {
    print("Введіть число для перевірки: ")
    val input = readLine()
    if (input.isNullOrBlank()) {
        println("Ви не ввели число.")
        return
    }

    val n = input.toLongOrNull()
    if (n == null) {
        println("Некоректний ввід. Будь ласка, введіть ціле число.")
        return
    }

    if (isPrime(n)) {
        println("$n є простим числом.")
    } else {
        println("$n не є простим числом.")
    }
}

fun isPrime(number: Long): Boolean {
    if (number < 2) return false
    if (number == 2L) return true
    if (number % 2L == 0L) return false

    val sqrtLimit = kotlin.math.sqrt(number.toDouble()).toLong()
    for (i in 3..sqrtLimit step 2) {
        if (number % i == 0L) {
            return false
        }
    }
    return true
}
