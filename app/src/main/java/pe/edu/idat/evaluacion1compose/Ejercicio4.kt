package pe.edu.idat.evaluacion1compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CuboCuartaApp() {
    var limiteInput by remember { mutableStateOf("4") }
    var secuencia by remember { mutableStateOf(listOf<String>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = limiteInput,
            onValueChange = { limiteInput = it },
            label = { Text("Ingrese el límite de la secuencia") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text("Secuencia:")
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(secuencia.size) { index ->
                Text(secuencia[index])
            }
        }
    }

    val limite = limiteInput.toIntOrNull()
    if (limite != null && limite > 0) {
        secuencia = calcularCuboCuarta(limite)
    } else {
        secuencia = listOf("Límite inválido. Debe ingresar un número entero positivo.")
    }
}

fun calcularCuboCuarta(limite: Int): List<String> {
    val secuencia = mutableListOf<String>()
    for (i in 1..limite) {
        val cubo = i * i * i
        val cuarta = cubo * i
        secuencia.add("$i^3 = $cubo, $i^4 = $cuarta")
    }
    return secuencia
}
@Preview
@Composable
fun DefaultPreview() {
    CuboCuartaApp()
}