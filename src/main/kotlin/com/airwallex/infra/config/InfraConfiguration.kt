package com.airwallex.infra.config

import com.airwallex.infra.domain.Balance
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import freemarker.template.Configuration
import freemarker.template.TemplateExceptionHandler
import org.springframework.context.annotation.Bean
import org.springframework.core.convert.converter.Converter
import org.springframework.core.convert.support.DefaultConversionService
import java.io.File

@org.springframework.context.annotation.Configuration
class InfraConfiguration {
    @Bean
    fun freemakerConfiguration() : Configuration {
        val cfg = Configuration(Configuration.VERSION_2_3_29)
        cfg.setDirectoryForTemplateLoading(File(javaClass.classLoader.getResource("templates")!!.file))
        cfg.defaultEncoding = "UTF-8"
        cfg.templateExceptionHandler = TemplateExceptionHandler.RETHROW_HANDLER
        cfg.logTemplateExceptions = false
        cfg.wrapUncheckedExceptions = true
        cfg.fallbackOnNullLoopVariable = false
        return cfg
    }

    @Bean
    fun convertService() : DefaultConversionService {
        val service = DefaultConversionService()
        service.addConverter(StringToBalanceConverter())
        return service
    }

    @Bean
    fun objectMapper() : ObjectMapper {
        return ObjectMapper().registerKotlinModule()
    }

    private class StringToBalanceConverter : Converter<String, Balance>  {
        override fun convert(source: String): Balance {
            return ObjectMapper().readValue(source, Balance::class.java)
        }
    }
}