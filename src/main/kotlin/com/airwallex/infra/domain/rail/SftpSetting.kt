
package com.airwallex.infra.domain.rail

class SftpSetting {
    var version: Long = System.currentTimeMillis()
    var timeout = 120 // in seconds
    var host: String? = null
    var username: String? = null
    var password: String? = null
    var allowUnknownKeys = false
    var knownHosts: String? = null
    var retryConnectionTimes = 3
    var privateKey: String? = null
    var privateKeyPassphrase: String? = null
    var operations: Map<String, SftpOperationSetting> = mapOf()
}
