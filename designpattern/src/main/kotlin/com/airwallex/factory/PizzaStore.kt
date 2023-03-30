package com.airwallex.factory

abstract class PizzaStore {

    fun orderPizza(type: String): Pizza {
        val pizza = createPizza(type)
        pizza.prepare()
        pizza.bake()
        pizza.cut()
        pizza.box()
        return pizza
    }

    abstract fun createPizza(type: String): Pizza
}