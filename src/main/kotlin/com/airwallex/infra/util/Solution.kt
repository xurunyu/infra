package com.airwallex.infra.util

import java.io.File
import java.util.UUID

object Solution {
    fun canJump(nums: IntArray): Boolean {
        var temp: Int = 0
        nums.forEachIndexed { index, i ->
            if(index <= temp) {
                temp = temp.coerceAtLeast(index + i)
            }
            if(temp >= nums.size) {
                return true
            }
        }
        return temp >= nums.size
    }

}

fun main() {
    val file = File("src/main/resources/static/output")
    file.writer().use {
        for (i in 0..9999) {
            it.append("INSERT INTO global_account_pool  (id, rail_id, currency, account_number, status, provider, purpose, expiry_date, version)\n" +
                    "VALUES ('${UUID.randomUUID()}', 'JPM-SG', 'SGD', '${1543523200 + i}', 'INIT', 'JPMSG_AWXSG', 'COLLECTION', date'2099-12-31', '0');"
            )
        }
    }
}