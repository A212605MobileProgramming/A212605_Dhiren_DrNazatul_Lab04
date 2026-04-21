package com.example.a212605_dhiren_drnazatul_lab04.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a212605_dhiren_drnazatul_lab04.R
import com.example.a212605_dhiren_drnazatul_lab04.ui.theme.A212605_Dhiren_DrNazatul_Lab04Theme

@Composable
fun StartOrderScreen(
    onStartOrderButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = onStartOrderButtonClicked,
            modifier = Modifier.widthIn(min = 250.dp)
        ) {
            Text(stringResource(R.string.start_order))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StartOrderScreenPreview() {
    A212605_Dhiren_DrNazatul_Lab04Theme {
        StartOrderScreen(onStartOrderButtonClicked = {})
    }
}
