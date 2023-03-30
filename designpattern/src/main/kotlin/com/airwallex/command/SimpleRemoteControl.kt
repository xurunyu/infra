package com.airwallex.command

class SimpleRemoteControl {
    lateinit var slot: Command
    fun buttonWasPressed() {
        slot.execute()
    }
}