package com.example.nelumbotechnicaltest.ui.common.error

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.nelumbotechnicaltest.R

@Composable
fun ErrorDialog(errorMessage: String, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(stringResource(R.string.error)) },
        text = { Text(stringResource(R.string.error_ocurred, errorMessage)) },
        confirmButton = {
            Button(onClick = onDismiss) {
                Text(stringResource(R.string.back))
            }
        }
    )
}