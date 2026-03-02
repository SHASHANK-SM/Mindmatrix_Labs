fun main() {

    // 1. Variables
    val studentName: String = "Shashank"
    var completedLabs: Int = 1

    // 2. String template
    println("Student Name: $studentName")
    println("Completed Labs: $completedLabs")

    // 3. List
    val topics = listOf(
        "Variables",
        "String Templates",
        "Functions",
        "Lists"
    )

    println("\nTopics practiced today:")
    for (topic in topics) {
        println("- $topic")
    }

    // 4. Function call
    val result = addNumbers(10, 20)
    println("\nResult from function: $result")
}

// 5. Function
fun addNumbers(a: Int, b: Int): Int {
    return a + b
}
