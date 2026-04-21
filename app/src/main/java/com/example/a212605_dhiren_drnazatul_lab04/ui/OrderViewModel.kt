package com.example.a212605_dhiren_drnazatul_lab04.ui

import androidx.lifecycle.ViewModel
import com.example.a212605_dhiren_drnazatul_lab04.model.AccompanimentItem
import com.example.a212605_dhiren_drnazatul_lab04.model.EntreeItem
import com.example.a212605_dhiren_drnazatul_lab04.model.MenuItem
import com.example.a212605_dhiren_drnazatul_lab04.model.OrderUiState
import com.example.a212605_dhiren_drnazatul_lab04.model.SideDishItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat

class OrderViewModel : ViewModel() {

    private val taxRate = 0.08

    private val _uiState = MutableStateFlow(OrderUiState())
    val uiState: StateFlow<OrderUiState> = _uiState.asStateFlow()

    fun updateEntree(entree: EntreeItem) {
        val previousEntree = _uiState.value.entree
        updateItem(entree, previousEntree)
    }

    fun updateSideDish(sideDish: SideDishItem) {
        val previousSideDish = _uiState.value.sideDish
        updateItem(sideDish, previousSideDish)
    }

    fun updateAccompaniment(accompaniment: AccompanimentItem) {
        val previousAccompaniment = _uiState.value.accompaniment
        updateItem(accompaniment, previousAccompaniment)
    }

    fun resetOrder() {
        _uiState.value = OrderUiState()
    }

    private fun updateItem(currentItem: MenuItem, previousItem: MenuItem?) {
        _uiState.update { currentState ->
            val previousItemPrice = previousItem?.price ?: 0.0
            val itemTotalPrice = currentState.itemTotalPrice - previousItemPrice + currentItem.price
            val tax = itemTotalPrice * taxRate
            currentState.copy(
                entree = if (currentItem is EntreeItem) currentItem else currentState.entree,
                sideDish = if (currentItem is SideDishItem) currentItem else currentState.sideDish,
                accompaniment = if (currentItem is AccompanimentItem) currentItem else currentState.accompaniment,
                itemTotalPrice = itemTotalPrice,
                orderTax = tax,
                orderTotalPrice = itemTotalPrice + tax
            )
        }
    }
}

fun Double.formatPrice(): String = NumberFormat.getCurrencyInstance().format(this)
