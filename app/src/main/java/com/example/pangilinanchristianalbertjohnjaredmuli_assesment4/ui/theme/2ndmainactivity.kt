package com.example.pangilinanchristianalbertjohnjaredmuli_assesment4

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
import java.time.LocalDate
import java.time.Period

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val name = intent.getStringExtra("name") ?: ""
        val birthdate = intent.getStringExtra("birthdate") ?: ""
        val gender = intent.getStringExtra("gender") ?: ""

        setContent {
            PangilinanChristianAlbertJohnJaredMuliAssesment4Theme {
                SecondScreen(name, birthdate, gender, onBack = { finish() })
            }
        }
    }
}

@Composable
fun SecondScreen(name: String, birthdate: String, gender: String, onBack: () -> Unit) {
    val prefix = if (gender.equals("Female", ignoreCase = true)) "Ms. " else "Mr. "

    val age = try {
        val parts = birthdate.split("-")
        val year = parts[0].toInt()
        val month = parts[1].toInt()
        val day = parts[2].toInt()

        val today = java.util.Calendar.getInstance()
        var ageCalc = today.get(java.util.Calendar.YEAR) - year

        val birthdayThisYear = java.util.GregorianCalendar(year, month - 1, day)
        if (today.get(java.util.Calendar.DAY_OF_YEAR) < birthdayThisYear.get(java.util.Calendar.DAY_OF_YEAR)) {
            ageCalc--
        }

        ageCalc
    } catch (e: Exception) {
        0
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = "Hello, $prefix$name!", style = MaterialTheme.typography.titleLarge)
        Text(text = "Age: $age", style = MaterialTheme.typography.bodyLarge)

        Button(onClick = onBack, modifier = Modifier.fillMaxWidth()) {
            Text("Back")
        }
    }
}
