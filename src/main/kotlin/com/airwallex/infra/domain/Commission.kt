package com.airwallex.infra.domain

import java.math.BigDecimal

data class Commission(
    val lowerBound: BigDecimal,
    val upperBound: BigDecimal? = null,
    val rate: Double
)