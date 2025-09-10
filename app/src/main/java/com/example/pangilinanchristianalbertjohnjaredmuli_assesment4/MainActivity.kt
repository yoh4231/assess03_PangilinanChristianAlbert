package com.example.pangilinanchristianalbertjohnjaredmuli_assesment4

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pangilinanchristianalbertjohnjaredmuli_assesment4.ui.theme.PangilinanChristianAlbertJohnJaredMuliAssesment4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PangilinanChristianAlbertJohnJaredMuliAssesment4Theme {
                MainForm { name, birthdate, gender ->
                    val intent = Intent(this, SecondActivity::class.java).apply {
                        putExtra("name", name)
                        putExtra("birthdate", birthdate)
                        putExtra("gender", gender)
                    }
                    startActivity(intent)
                }
            }
        }
    }
}

@Composable
fun MainForm(onNext: (String, String, String) -> Unit) {
    var name by remember { mutableStateOf("") }
    var birthdate by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Enter your name") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = birthdate,
            onValueChange = { birthdate = it },
            label = { Text("Enter birthdate (yyyy-MM-dd)") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = gender,
            onValueChange = { gender = it },
            label = { Text("Enter gender (Male/Female)") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { onNext(name, birthdate, gender) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Next")
        }
    }
}
