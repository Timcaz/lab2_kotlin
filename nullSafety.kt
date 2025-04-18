data class Address(val city: String, val street: String)
data class User(val name: String, val address: Address?)

fun main() {
    val user1 = User("Іван", Address("Київ", "Хрещатик"))
    val user2 = User("Марія", null)

    println("Місто користувача ${user1.name}: ${user1.address?.city ?: "Невідомо"}")
    println("Місто користувача ${user2.name}: ${user2.address?.city ?: "Невідомо"}")
}