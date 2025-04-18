import java.lang.Exception

class InvalidExpenseException(message: String) : Exception(message)

fun main() {
    println("Фінансовий трекер: введіть витрати за тиждень (по одній витраті на день)")
    val expenses = mutableListOf<Double>()
    
    for (day in 1..7) {
        print("Введіть витрату за день $day: ")
        val input = readLine()
        val expense = input?.toDoubleOrNull()
        
        if (expense == null) {
            println("Некоректний ввід. Спробуйте ще раз.")
            continue
        }
        
        try {
            if (expense < 0) {
                throw InvalidExpenseException("Витрата не може бути від'ємною!")
            }
            expenses.add(expense)
        } catch (e: InvalidExpenseException) {
            println("Помилка: ${e.message}")
            dayDown@ while (true) {
                print("Введіть коректну витрату за день $day: ")
                val retryInput = readLine()
                val retryExpense = retryInput?.toDoubleOrNull()
                if (retryExpense == null || retryExpense < 0) {
                    println("Некоректне значення. Спробуйте ще раз.")
                } else {
                    expenses.add(retryExpense)
                    break@dayDown
                }
            }
        }
    }
    
    val totalExpenses = expenses.sum()
    val maxExpense = expenses.maxOrNull() ?: 0.0
    val maxExpenseDay = expenses.indexOf(maxExpense) + 1
    val averageExpense = if (expenses.isNotEmpty()) totalExpenses / expenses.size else 0.0
    val expenseEvaluation = when {
        totalExpenses < 500 -> "Економно"
        totalExpenses in 500.0..1000.0 -> "Помірно"
        totalExpenses > 1000 -> "Занадто багато"
        else -> "Невизначено"
    }

    println("\nРезультати:")
    println("Загальні витрати: $totalExpenses")
    println("День з найбільшою витратою: День $maxExpenseDay (витрата: $maxExpense)")
    println("Середня витрата: ${"%.2f".format(averageExpense)}")
    println("Оцінка витрат: $expenseEvaluation")
}
