package com.airwallex.factory

class NYStyleCheesePizza : Pizza() {
    init {
        name = "NY Style Souce and Cheese Pizza"
        dough = "Thin Crust Dough"
        sauce = "Marinara Sauce"
        toppings.add("Grated Reggiano Chess")
    }
}
