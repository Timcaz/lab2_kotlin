fun main() {
    val numbers = arrayOf(5, 12, 7, 20, 33, 18)

    print("Введіть число, яке потрібно знайти в масиві: ")
    val input = readLine()

    val target = input?.toIntOrNull()
    if (target == null) {
        println("Некоректний ввід. Будь ласка, введіть ціле число.")
        return
    }

    var found = false
    for (num in numbers) {
        if (num == target) {
            found = true
            break
        }
    }

    if (found) {
        println("За допомогою циклу: Число $target присутнє в масиві.")
    } else {
        println("За допомогою циклу: Число $target відсутнє в масиві.")
    }
}
