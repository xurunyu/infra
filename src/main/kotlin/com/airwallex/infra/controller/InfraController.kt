package com.airwallex.infra.controller

import com.airwallex.infra.service.ContentGenerateService
import com.airwallex.infra.util.Converter
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
class InfraController(
    private val contentGenerateService: ContentGenerateService,
    private val objectMapper: ObjectMapper,
) {

    private val logger: Logger = LoggerFactory.getLogger(InfraController::class.java)

    @PostMapping("/content/{operation}/{type}")
    @ResponseBody
    fun generateContent(@PathVariable("operation") operation: String, @PathVariable("type") type: String, @RequestBody request: String): String {
        return contentGenerateService.generate(operation, type, request).also {
            logger.info(it)
        }
    }

    @GetMapping("/request/{name}")
    @ResponseBody
    fun getRequest(@PathVariable("name") name: String): String {
        return Converter.convert(name).let {
            objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(it)
        }.also {
            logger.info(it)
        }
    }
}
