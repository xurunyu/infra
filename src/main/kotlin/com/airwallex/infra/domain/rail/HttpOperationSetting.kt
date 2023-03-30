package com.airwallex.infra.domain.rail

data class HttpOperationSetting(
    val method: String,
    val url: String,
    val headers: Map<String, String> = mapOf()
)
