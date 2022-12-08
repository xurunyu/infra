package com.airwallex.infra.service

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Service
import java.io.StringWriter
import java.io.Writer

@Service
class PurposeContent(
    private val templateService: TemplateService,
    private val objectMapper: ObjectMapper,
): ContentBuilder {
    override fun canBuild(type: String): Boolean {
        return type.trim().lowercase() == "purpose"
    }

    override fun build(operation: String, content: String): String {
        val purposes = getPurposes(content)
        val template = templateService.getTemplate("purpose_template")
        require(template != null)
        val out: Writer = StringWriter()

        out.use {
            template.process(mapOf("purposes" to purposes),out)
        }
        return out.toString()
    }

    fun getPurposes(content: String): List<Purpose> {
        val result = mutableListOf<Purpose>()
        val lines = content.split(Regex("\n"))
        val heads = lines.subList(0,23)
        val aedPurpose = lines.subList(23,46)
        val ilsPurpose = lines.subList(46,69)

        aedPurpose.forEachIndexed { index, s ->
            if (s.isNotBlank()) {
                result.add(Purpose("AED_${heads[index]}", s))
            }
        }
        ilsPurpose.forEachIndexed { index, s ->
            if (s.isNotBlank()) {
                result.add(Purpose("ILS_${heads[index]}", s))
            }
        }
        return result
    }

    data class Purpose(
        val fromCode: String,
        val toCode: String,
    )
}