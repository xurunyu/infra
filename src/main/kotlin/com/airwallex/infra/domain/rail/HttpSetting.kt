package com.airwallex.infra.domain.rail

class HttpSetting {
    var version: Long = System.currentTimeMillis()
    var connectTimeout: Int = 10
    var readTimeout: Int = 10
    var connectionRequestTimeout: Int = 55
    var clientKeyStore: String? = null
    var clientKeyStorePwd: String? = null
    var clientKeyStoreType: String? = null
    var clientKeyPwd: String? = null
    var trustKeyStore: String? = null
    var trustKeyStoreType: String? = null
    var trustKeyStorePwd: String? = null
    var operations: Map<String, HttpOperationSetting> = mapOf()
}
