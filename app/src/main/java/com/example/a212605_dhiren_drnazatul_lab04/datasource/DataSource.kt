package com.example.a212605_dhiren_drnazatul_lab04.datasource

import com.example.a212605_dhiren_drnazatul_lab04.model.AccompanimentItem
import com.example.a212605_dhiren_drnazatul_lab04.model.EntreeItem
import com.example.a212605_dhiren_drnazatul_lab04.model.SideDishItem

object DataSource {
    val entreeMenuItems = listOf(
        EntreeItem(
            name = "Cauliflower",
            description = "A veggified noodle bowl with cauliflower florets, broccoli, edamame and cream sauce.",
            price = 7.00
        ),
        EntreeItem(
            name = "Three Bean Chili",
            description = "Vegan chili topped with sharp cheddar and avocado.",
            price = 4.00
        ),
        EntreeItem(
            name = "Mushroom Pasta",
            description = "Penne pasta with mushrooms, caramelized onions, spinach, tomatoes, and arugula.",
            price = 5.50
        ),
        EntreeItem(
            name = "Spicy Black Bean Skillet",
            description = "Black beans with peppers, and red onion, drizzled in sauce.",
            price = 5.50
        )
    )

    val sideDishMenuItems = listOf(
        SideDishItem(
            name = "Summer Salad",
            description = "Seasonal vegetables with balsamic dressing.",
            price = 2.50
        ),
        SideDishItem(
            name = "Butternut Squash Soup",
            description = "Creamy butternut squash soup with roasted pepitas.",
            price = 3.00
        ),
        SideDishItem(
            name = "Spicy Potatoes",
            description = "Crispy fried potato slices, seasoned with spicy sauce.",
            price = 2.00
        ),
        SideDishItem(
            name = "Coconut Rice",
            description = "Fragrant coconut-infused rice garnished with cilantro.",
            price = 1.50
        )
    )

    val accompanimentMenuItems = listOf(
        AccompanimentItem(
            name = "Lunch Roll",
            description = "Soft dinner roll.",
            price = 0.50
        ),
        AccompanimentItem(
            name = "Artisanal Bread Slice",
            description = "Hearty slice of bread with butter.",
            price = 1.00
        ),
        AccompanimentItem(
            name = "Pickled Veggies",
            description = "Pickled cucumbers and carrots.",
            price = 0.50
        )
    )
}
