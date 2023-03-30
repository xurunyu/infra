package com.airwallex.command

import com.airwallex.command.model.Light
import org.junit.jupiter.api.Test

class SimpleRemoteControlTest{
    @Test
    fun `test light on`() {
        val remote = SimpleRemoteControl()
        val light = Light()
        val lightOn = LightOnCommand(light)
        remote.slot = lightOn
        remote.buttonWasPressed()
    }


}