package com.airwallex.infra.controller

import com.airwallex.infra.domain.rail.StartRemitRequest
import com.airwallex.infra.service.RemitService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController("/app/uat")
class RemitController(
    private val remitService: RemitService
) {

    private val logger = LoggerFactory.getLogger(RemitController::class.java)


    @PostMapping("/InwardRemittanceByPartnerService2SSL")
    fun startRemit(startRemitRequest: StartRemitRequest) {
        logger.info("get request ${startRemitRequest.uniqueRequestNo}")
        try {
            remitService.startRemit(startRemitRequest)
        } catch (e: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "time out")
        }
    }
}