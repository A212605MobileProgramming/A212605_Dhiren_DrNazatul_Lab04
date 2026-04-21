package com.example.a212605_dhiren_drnazatul_lab04.datasource

import com.example.a212605_dhiren_drnazatul_lab04.model.FlashDeal
import com.example.a212605_dhiren_drnazatul_lab04.model.FoodCategory
import com.example.a212605_dhiren_drnazatul_lab04.model.FoodDeal

object DataSource {

    val flashDeals = listOf(
        FlashDeal("🍱", "Bento\n-50%"),
        FlashDeal("🍜", "Noodles\n-40%"),
        FlashDeal("🎂", "Cakes\n-60%"),
        FlashDeal("🥗", "Salad\n-30%")
    )

    val categories = listOf(
        FoodCategory("🛍️", "Mystery"),
        FoodCategory("🍽️", "Dine-In"),
        FoodCategory("🥘", "Meals"),
        FoodCategory("🍰", "Dessert")
    )

    val budgetPicks = listOf(
        FoodDeal(
            emoji = "🍽️",
            name = "Weekdays Set Lunch",
            price = "RM 8.90",
            oldPrice = "RM 18.00",
            discount = "50% off",
            location = "Cafe Mahallah",
            time = "12:00-14:00",
            detail = "Includes rice and protein of your choice."
        ),
        FoodDeal(
            emoji = "🥗",
            name = "Healthy Box",
            price = "RM 7.50",
            oldPrice = "RM 15.00",
            discount = "50% off",
            location = "GreenBite",
            time = "11:00-14:00",
            detail = "Fresh salad with grilled chicken and dressing."
        )
    )
}
