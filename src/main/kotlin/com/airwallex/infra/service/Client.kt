package com.airwallex.infra.service

import org.apache.http.client.config.RequestConfig
import org.apache.http.config.RegistryBuilder
import org.apache.http.conn.socket.ConnectionSocketFactory
import org.apache.http.conn.socket.PlainConnectionSocketFactory
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager
import java.util.UUID
import java.util.concurrent.TimeUnit

class Client() {

    fun initClient() : CloseableHttpClient {
        val config = RequestConfig.custom()
            .setConnectTimeout(60 * 1000)
            .setConnectionRequestTimeout(60 * 1000)
            .setSocketTimeout(60 * 1000)
            .build()

        val registry = RegistryBuilder.create<ConnectionSocketFactory>()
            .register("http", PlainConnectionSocketFactory())
            .build()

        val httpClientConnectionManager = PoolingHttpClientConnectionManager(registry)

        return HttpClientBuilder.create()
            .setConnectionManager(httpClientConnectionManager)
            .evictExpiredConnections()
            .evictIdleConnections(5, TimeUnit.SECONDS)
            .setDefaultRequestConfig(config).build()
    }

}
//fun main() {
//    val httpClient = Client().initClient()
//
//
//    while (true) {
//
//        val uniqueId = UUID.randomUUID()
//        val str = StringTemplateUtils.marshall(mapOf("id" to uniqueId), "request.ftl")
//
//        val postRequest = HttpPost("http://localhost:8080/disbursement")
//        val entity = StringEntity(str.replace("\n", "").trim()
//            , ContentType.APPLICATION_JSON )
//        postRequest.entity = entity
//        val response = httpClient.execute(postRequest).also {
//            EntityUtils.consume(it.entity)
//        }
//
//        Thread.sleep(1000L)
//    }
//    println(UUID.randomUUID())
//}