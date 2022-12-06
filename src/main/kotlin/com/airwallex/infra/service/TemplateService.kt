package com.airwallex.infra.service

import freemarker.template.Configuration
import freemarker.template.Template
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Service
import java.io.File

@Service
class TemplateService(
    private val configuration: Configuration,
) {
    private val templateMap = HashMap<String, Template>()

    @PostConstruct
    fun init() {
        val templatePath = File(javaClass.classLoader.getResource("templates")!!.file)
        if (templatePath.isDirectory) {
            templatePath.listFiles()?.forEach {
                templateMap[it.name] = configuration.getTemplate(it.name)
            }
        }
    }

    fun getTemplate(name: String)  = templateMap[name]
}