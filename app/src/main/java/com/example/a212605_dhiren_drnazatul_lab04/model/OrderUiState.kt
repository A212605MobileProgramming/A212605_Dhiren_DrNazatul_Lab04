package com.example.a212605_dhiren_drnazatul_lab04.model

data class OrderUiState(
    val entree: EntreeItem? = null,
    val sideDish: SideDishItem? = null,
    val accompaniment: AccompanimentItem? = null,
    val itemTotalPrice: Double = 0.0,
    val orderTax: Double = 0.0,
    val orderTotalPrice: Double = 0.0
)
