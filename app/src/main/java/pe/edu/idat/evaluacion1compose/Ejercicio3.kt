package pe.edu.idat.evaluacion1compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyApp() {
    var number by remember { mutableStateOf("4") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = number,
            onValueChange = { number = it },
            label = { Text("Ingrese un número entero del 1 al 5") },
            modifier = Modifier.padding(horizontal = 16.dp),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(16.dp))
        val vowel = getVowel(number.toIntOrNull())
        Text(
            text = "La vocal correspondiente es: $vowel",
            style = MaterialTheme.typography.headlineLarge
        )
    }
}

fun getVowel(number: Int?): String {
    return when (number) {
        1 -> "A"
        2 -> "E"
        3 -> "I"
        4 -> "O"
        5 -> "U"
        else -> "Vocal no válida"
    }
}

@Preview
@Composable
fun PreviewMyApp() {
    MyApp()
}
