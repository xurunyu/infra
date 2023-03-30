package com.airwallex.factory

class ChicagoStyleCheesePizza : Pizza() {
    init {
        name = "Chicago Style Deep Dish Cheese Pizza"
        dough = "Extra Think Crust Dough"
        sauce = "Plum Tomato Sauce"
        toppings.add("Shredded Mozzarella Chess")
    }

    override fun cut() {
        print("Cutting the pizza into square slices")
    }
}
