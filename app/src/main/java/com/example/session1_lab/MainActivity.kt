import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Variables
        val studentName: String = "Shashank"
        val completedLabs = 1

        // 2. String template
        val message1 = "Student Name: $studentName"
        val message2 = "Completed Labs: $completedLabs"

        // 3. List
        val topics = listOf(
            "Variables",
            "String Templates",
            "Functions",
            "Lists"
        )

        // 4. Function call
        val result = addNumbers(10, 20)

        setContent {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = message1)
                Text(text = message2)

                Text(text = "Topics practiced:")

                for (topic in topics) {
                    Text(text = "- $topic")
                }

                Text(text = "Result from function: $result")
            }
        }
    }
}

fun addNumbers(a: Int, b: Int): Int {
    return a + b
}
