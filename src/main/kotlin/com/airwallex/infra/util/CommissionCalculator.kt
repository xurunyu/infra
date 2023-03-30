package com.airwallex.infra.util

import com.airwallex.infra.domain.Commission
import java.math.BigDecimal
import java.math.RoundingMode
import java.util.Scanner

class CommissionCalculator {
    val rate1 = Commission(BigDecimal(0.01), BigDecimal(5000), 0.08)
    val rate2 = Commission(BigDecimal(5000.01), BigDecimal(10000), 0.1)
    val rate3 = Commission(BigDecimal(10000.01), rate = 0.12)


    fun calculate(income: BigDecimal) : BigDecimal {
        val commission = income.minus(BigDecimal(5000))
        if (commission < BigDecimal.ZERO) {
            return BigDecimal.ZERO
        }
        val commissionRank1 = rate1.upperBound!!.multiply(BigDecimal(rate1.rate))
        val commissionRank2 = rate2.upperBound!!.minus(rate1.lowerBound).multiply(BigDecimal(rate2.rate))
        return if (commission > commissionRank1.add(commissionRank2)) {
            commission.minus(commissionRank2).minus(commissionRank1).divide(BigDecimal(rate3.rate),2, RoundingMode.CEILING).plus(rate2.upperBound)
        } else if (commission > commissionRank1) {
            commission.minus(commissionRank1).divide(BigDecimal(rate2.rate),2, RoundingMode.CEILING).plus(rate1.upperBound)
        } else {
            commission.divide(BigDecimal(rate1.rate),2, RoundingMode.CEILING)
        }
    }

}

//fun main(args: Array<String>) {
//    val calculator = CommissionCalculator()
//    val scanner = Scanner(System.`in`)
//    val income = scanner.nextInt()
//    println(calculator.calculate(BigDecimal(income)))
//}