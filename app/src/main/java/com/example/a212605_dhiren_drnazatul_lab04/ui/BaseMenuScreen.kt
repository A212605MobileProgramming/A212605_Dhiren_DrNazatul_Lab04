package com.example.a212605_dhiren_drnazatul_lab04.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.a212605_dhiren_drnazatul_lab04.R
import com.example.a212605_dhiren_drnazatul_lab04.model.MenuItem

@Composable
fun BaseMenuScreen(
    options: List<MenuItem>,
    onCancelButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit,
    onSelectionChanged: (MenuItem) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedItemName by rememberSaveable { mutableStateOf("") }

    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        Column(modifier = Modifier.selectableGroup()) {
            options.forEach { item ->
                MenuItemRow(
                    item = item,
                    selectedItemName = selectedItemName,
                    onSelectionChanged = { name ->
                        selectedItemName = name
                        onSelectionChanged(item)
                    }
                )
            }
        }
        MenuScreenButtonGroup(
            selectedItemName = selectedItemName,
            onCancelButtonClicked = onCancelButtonClicked,
            onNextButtonClicked = onNextButtonClicked
        )
    }
}

@Composable
fun MenuItemRow(
    item: MenuItem,
    selectedItemName: String,
    onSelectionChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selectedItemName == item.name,
            onClick = { onSelectionChanged(item.name) }
        )
        Column(modifier = Modifier.weight(1f)) {
            Text(text = item.name)
            Text(text = item.description)
            Text(text = item.getFormattedPrice())
        }
    }
    HorizontalDivider()
}

@Composable
fun MenuScreenButtonGroup(
    selectedItemName: String,
    onCancelButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        OutlinedButton(onClick = onCancelButtonClicked) {
            Text(stringResource(R.string.cancel))
        }
        Button(
            onClick = onNextButtonClicked,
            enabled = selectedItemName.isNotEmpty()
        ) {
            Text(stringResource(R.string.next))
        }
    }
}
