package com.example.studentreportapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Sample marks
        val marks = listOf(85, 72, 90, 66, 58)

        // Generate report using function
        val report = generateStudentReport("Shashank", marks)

        setContent {
            MaterialTheme {
                Surface {
                    ReportScreen(report)
                }
            }
        }
    }
}

/* ---------- UI ---------- */

@Composable
fun ReportScreen(report: String) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = report)
    }
}

/* ---------- Logic Part ---------- */

// Function to generate full report
fun generateStudentReport(name: String, marks: List<Int>): String {

    var total = 0

    // Loop to calculate total
    for (mark in marks) {
        total += mark
    }

    val average = total / marks.size

    // Condition to find grade
    val grade = calculateGrade(average)

    return buildString {
        append("Student Performance Report\n\n")
        append("Name: $name\n")
        append("Marks:\n")

        // Loop to display each subject mark
        for (i in marks.indices) {
            append("Subject ${i + 1}: ${marks[i]}\n")
        }

        append("\nTotal: $total")
        append("\nAverage: $average")
        append("\nGrade: $grade")
    }
}

// Function to decide grade using conditions
fun calculateGrade(avg: Int): String {

    return when {
        avg >= 90 -> "A+"
        avg >= 80 -> "A"
        avg >= 70 -> "B"
        avg >= 60 -> "C"
        avg >= 50 -> "D"
        else -> "Fail"
    }
}