package pe.edu.idat.evaluacion1compose

import androidx.compose.foundation.layout.*
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
fun CalculadoraDescuento() {
    var cantidad by remember { mutableStateOf(5) }
    var precio by remember { mutableStateOf(30f) }

    val total by remember {
        derivedStateOf {
            cantidad * precio * if (cantidad * precio > 200) 0.8f else 1.0f
        }
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = cantidad.toString(),
            onValueChange = { value ->
                cantidad = value.toIntOrNull() ?: 0
            },
            label = { Text("Quantity") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )

        OutlinedTextField(
            value = precio.toString(),
            onValueChange = { value ->
                precio = value.toFloatOrNull() ?: 0f
            },
            label = { Text("Price") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Total: S/.${String.format("%.2f", total)}")
    }
}

@Composable
@Preview
fun PreviewDiscountCalculator() {
    CalculadoraDescuento()
}
