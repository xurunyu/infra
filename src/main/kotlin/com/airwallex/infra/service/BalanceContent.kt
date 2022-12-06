package com.airwallex.infra.service

import com.airwallex.infra.domain.Balance
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Service
import java.io.StringWriter
import java.io.Writer
import java.math.BigDecimal
import java.math.RoundingMode

@Service
class BalanceContent(
    private val templateService: TemplateService,
    private val objectMapper: ObjectMapper,
) : ContentBuilder{

    private val fx = mapOf(
        "SGD" to BigDecimal(0.724),
        "USD" to BigDecimal(1),
        "AUD" to BigDecimal(0.641),
        "CAD" to BigDecimal(0.74),
        "CHF" to BigDecimal(1.014),
        "CNY" to BigDecimal(0.14),
        "EUR" to BigDecimal(1.04),
        "GBP" to BigDecimal(1.21),
        "HKD" to BigDecimal(0.13),
        "JPY" to BigDecimal(0.0073),
        "NOK" to BigDecimal(0.10),
        "NZD" to BigDecimal(0.62),
        "SEK" to BigDecimal(0.096),
    )

    private val dates = listOf(
        "2022-10-03",  "2022-10-10", "2022-10-17", "2022-10-24", "2022-10-31",
    )

    override fun canBuild(type : String) : Boolean {
        return type.trim().lowercase() == "balance"
    }

    override fun build(operation: String, content: String): String {
        val balances = objectMapper.readValue(content, object : TypeReference<List<Balance>>() {})
        val template = templateService.getTemplate("${operation}_balance_template")
        require(template != null)
        val out: Writer = StringWriter()

        out.use {
            balances.map { balance ->
                val fields = getFields(balance)
                template.process(fields,out)
            }
        }
        return out.toString()
    }

    private fun getFields(balance: Balance): Map<String, String> {
        return mapOf(
            "balance" to balance.balance.toString(),
            "usd_balance" to balance.balance.multiply(fx[balance.currency]).setScale(2, RoundingMode.HALF_EVEN).toString(),
            "currency" to balance.currency,
            "date" to balance.date,
        )
    }
}

//fun main() {
//    val balances = listOf(
//        Balance(
//            date = "2022-10-30",
//            balance = BigDecimal(100),
//            currency = "USD"
//        )
//    )
//    println(ObjectMapper().writeValueAsString(balances))
//
//    val str = "[\n" +
//            "    {\n" +
//            "        \"currency\": \"USD\",\n" +
//            "        \"balance\": 100,\n" +
//            "        \"date\": \"2022-10-30\"\n" +
//            "    },\n" +
//            "        {\n" +
//            "        \"currency\": \"SGD\",\n" +
//            "        \"balance\": 200,\n" +
//            "        \"date\": \"2022-10-30\"\n" +
//            "    }\n" +
//            "]"
//    val values = ObjectMapper().readValue(str, object : TypeReference<List<Balance>>() {})
//    println(values)
//}