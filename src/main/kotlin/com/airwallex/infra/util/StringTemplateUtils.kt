package com.airwallex.infra.util

import freemarker.template.Configuration
import freemarker.template.DefaultObjectWrapper
import org.apache.logging.log4j.LogManager.getLogger
import java.io.StringWriter

object StringTemplateUtils {
    private val logger = getLogger()

    private val configuration = Configuration(Configuration.VERSION_2_3_29)

    init {
        configuration.objectWrapper = DefaultObjectWrapper(Configuration.VERSION_2_3_29)
        configuration.setClassLoaderForTemplateLoading(javaClass.classLoader, "/templates")
    }

    fun marshall(message: Any): String {
        return marshall(message, message.javaClass.simpleName + ".ftl")
    }

    fun marshall(message: Any, path: String): String {
        try {
            val t = configuration.getTemplate(path)

            val sw = StringWriter()
            t.process(message, sw)

            return sw.toString()
        } catch (e: Exception) {
            logger.error("marsall file with $path format failed", e)
        }
        return ""
    }
}