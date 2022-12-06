package com.airwallex.infra.util

import com.airwallex.infra.domain.Balance
import org.slf4j.LoggerFactory
import org.springframework.util.StringUtils
import java.io.File
import java.math.BigDecimal

object Converter {
    private val logger = LoggerFactory.getLogger(Converter::class.java)

    fun convert(fileName: String) : List<Balance> {
        val file = File(javaClass.classLoader.getResource("static/$fileName")!!.file)
        return file.readLines().filter { StringUtils.hasLength(it) }.map {
            val fields = it.split(",")
            Balance(
                date = fields[0],
                currency = fields[1],
                balance = BigDecimal(fields[2])
            )
        }
    }
}