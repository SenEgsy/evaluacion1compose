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
fun LoanCalculator() {
    var loanAmount by remember { mutableStateOf(8000) }

    val totalDebt by remember {
        derivedStateOf {
            val interestRate = if (loanAmount < 4000) 0.12 else 0.10
            val totalAmount = loanAmount * (1 + interestRate)
            val numberOfInstallments = when {
                loanAmount > 5000 -> 3
                loanAmount < 1000 -> 1
                loanAmount in 2000..3000 -> 2
                else -> 5
            }
            totalAmount to numberOfInstallments
        }
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = loanAmount.toString(),
            onValueChange = { value ->
                loanAmount = value.toIntOrNull() ?: 0
            },
            label = {Text("Loan Amount") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (loanAmount != 0) {
            Text("Deuda total: S/.${String.format("%.2f", totalDebt.first)}")
            Text("Numero de Plazos: ${totalDebt.second}")
            Text("Monto por Couta: S/.${String.format("%.2f", totalDebt.first / totalDebt.second)}")
        }
    }
}

@Composable
@Preview
fun PreviewLoanCalculator() {
    LoanCalculator()
}
