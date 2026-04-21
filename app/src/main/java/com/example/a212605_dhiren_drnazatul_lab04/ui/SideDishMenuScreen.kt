package com.example.a212605_dhiren_drnazatul_lab04.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a212605_dhiren_drnazatul_lab04.datasource.DataSource
import com.example.a212605_dhiren_drnazatul_lab04.model.SideDishItem

@Composable
fun SideDishMenuScreen(
    options: List<SideDishItem>,
    onCancelButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit,
    onSelectionChanged: (SideDishItem) -> Unit,
    modifier: Modifier = Modifier
) {
    BaseMenuScreen(
        options = options,
        onCancelButtonClicked = onCancelButtonClicked,
        onNextButtonClicked = onNextButtonClicked,
        onSelectionChanged = { onSelectionChanged(it as SideDishItem) },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun SideDishMenuScreenPreview() {
    SideDishMenuScreen(
        options = DataSource.sideDishMenuItems,
        onCancelButtonClicked = {},
        onNextButtonClicked = {},
        onSelectionChanged = {},
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    )
}
