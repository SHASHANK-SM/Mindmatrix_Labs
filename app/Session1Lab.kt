fun addNumbers(a: Int, b: Int): Int {
    return a + b
}

fun sessionOneLab() {

    val studentName = "Shashank"
    var completedLabs = 1

    println("Student Name: $studentName")
    println("Completed Labs: $completedLabs")

    val topics = listOf(
        "Variables",
        "String Templates",
        "Functions",
        "Lists"
    )

    for (topic in topics) {
        println(topic)
    }

    val result = addNumbers(10, 20)
    println("Result: $result")
}
