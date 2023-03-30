package com.airwallex.factory

import java.util.ArrayList

abstract class Pizza {

    var name: String? = null
    var dough: String? = null
    var sauce: String? = null
    val toppings = ArrayList<String>()

    fun prepare() {
        println("Preparing $name")
        println("Tossing dough...")
        println("Adding sauce...")
        println("Adding toppings: ")
        toppings.forEach {
            println("   $it")
        }
    }
    open fun bake() {
        println("Bake for 25 minutes at 350")
    }

    open fun cut() {
        println("Cutting the pizza inta diagonal slices")
    }

    open fun box() {
        println("Place pizza in official PizzaStore box")
    }
}

fun main() {
    val nyStore: PizzaStore = NYPizzaStore()
    val pizza = nyStore.orderPizza("cheese")
    println("Ethan order a ${pizza.name}")
}