package com.airwallex.infra.domain.rail

data class RailSetting(
    val api: HttpSetting? = null,
    val webhook: WebhookSetting? = null,
    val sftp: SftpSetting? = null
)
