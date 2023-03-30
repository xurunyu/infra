package com.airwallex.factory

class NYPizzaStore : PizzaStore() {
    override fun createPizza(type: String): Pizza {
        var pizza: Pizza? = null
        if (type == "cheese") {
            pizza = NYStyleCheesePizza()
        }
        return pizza!!
    }
}