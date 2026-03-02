package com.example.userprofileconsole

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

// ---------------- Data class ----------------

data class UserProfile(
    val name: String,
    val age: Int,
    val email: String,
    val showAvatar: Boolean
)

// ---------------- Activity ----------------

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val users = listOf(
            UserProfile("Shashank", 20, "shashank@gmail.com", true),
            UserProfile("Aditi", 21, "aditi@gmail.com", false),
            UserProfile("Rahul", 22, "rahul@gmail.com", true)
        )

        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    UserList(users)
                }
            }
        }
    }
}

// ---------------- UI ----------------

@Composable
fun UserList(users: List<UserProfile>) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        items(users) { user ->
            UserProfileCard(user)
        }
    }
}

@Composable
fun UserProfileCard(user: UserProfile) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {

        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // -------- Condition for avatar --------
            if (user.showAvatar) {

                Image(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = "Avatar",
                    modifier = Modifier
                        .size(64.dp)
                        .padding(end = 12.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Column {
                Text(text = "Name : ${user.name}")
                Text(text = "Age : ${user.age}")
                Text(text = "Email : ${user.email}")
            }
        }
    }
}