package com.airwallex.command

import com.airwallex.command.model.Light

class LightOnCommand(private var light: Light) : Command {

    override fun execute() {
        light.on()
    }
}