package com.airwallex.infra.service

interface ContentBuilder {

    fun canBuild(type: String) : Boolean

    fun build(operation: String, content: String) : String
}