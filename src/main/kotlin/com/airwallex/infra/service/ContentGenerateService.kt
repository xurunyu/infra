package com.airwallex.infra.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service


@Service
class ContentGenerateService(
    private val builder: List<ContentBuilder>
) {
    private val logger: Logger = LoggerFactory.getLogger(ContentGenerateService::class.java)

    fun generate(operation: String, type: String, content: String) : String {
        return try {
            builder.single { it.canBuild(type) }
                .build(operation, content)
        } catch (e: Exception) {
            logger.error("failed in genereate", e)
            ""
        }
    }
}