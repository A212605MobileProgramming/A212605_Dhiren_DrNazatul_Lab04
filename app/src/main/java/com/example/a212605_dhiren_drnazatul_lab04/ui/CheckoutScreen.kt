package com.example.a212605_dhiren_drnazatul_lab04.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a212605_dhiren_drnazatul_lab04.R
import com.example.a212605_dhiren_drnazatul_lab04.datasource.DataSource
import com.example.a212605_dhiren_drnazatul_lab04.model.MenuItem
import com.example.a212605_dhiren_drnazatul_lab04.model.OrderUiState

@Composable
fun CheckoutScreen(
    orderUiState: OrderUiState,
    onCancelButtonClicked: () -> Unit,
    onSendButtonClicked: (String, String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(text = stringResource(R.string.order_summary))
        orderUiState.entree?.let { ItemSummary(item = it) }
        orderUiState.sideDish?.let { ItemSummary(item = it) }
        orderUiState.accompaniment?.let { ItemSummary(item = it) }
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        OrderSubCost(
            label = stringResource(R.string.subtotal, orderUiState.itemTotalPrice.formatPrice())
        )
        OrderSubCost(
            label = stringResource(R.string.tax, orderUiState.orderTax.formatPrice())
        )
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        OrderSubCost(
            label = stringResource(R.string.total, orderUiState.orderTotalPrice.formatPrice())
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(onClick = onCancelButtonClicked) {
                Text(stringResource(R.string.cancel))
            }
            Button(onClick = {
                onSendButtonClicked(
                    orderUiState.entree?.name ?: "",
                    orderUiState.orderTotalPrice.formatPrice()
                )
            }) {
                Text(stringResource(R.string.submit))
            }
        }
    }
}

@Composable
fun ItemSummary(item: MenuItem, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = item.name)
        Text(text = item.getFormattedPrice())
    }
}

@Composable
fun OrderSubCost(label: String, modifier: Modifier = Modifier) {
    Text(
        text = label,
        modifier = modifier.padding(vertical = 4.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun CheckoutScreenPreview() {
    CheckoutScreen(
        orderUiState = OrderUiState(
            entree = DataSource.entreeMenuItems[0],
            sideDish = DataSource.sideDishMenuItems[0],
            accompaniment = DataSource.accompanimentMenuItems[0],
            itemTotalPrice = 10.00,
            orderTax = 0.80,
            orderTotalPrice = 10.80
        ),
        onCancelButtonClicked = {},
        onSendButtonClicked = { _, _ -> }
    )
}
