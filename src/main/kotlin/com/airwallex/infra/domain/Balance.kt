package com.airwallex.infra.domain

import java.math.BigDecimal

data class Balance(
    val currency: String,
    val date: String,
    val balance: BigDecimal = BigDecimal.ZERO,
)
