package com.airwallex.infra.service

import com.airwallex.infra.domain.rail.RemitBody
import com.airwallex.infra.domain.rail.RemitResponse
import com.airwallex.infra.domain.rail.StartRemitRequest
import com.airwallex.infra.domain.rail.StartRemitResponse
import org.springframework.stereotype.Component

@Component
class RemitService {

    fun startRemit(startRemitRequest: StartRemitRequest): StartRemitResponse {
        return StartRemitResponse().apply {
            body = RemitBody().apply {
                remitResponse = RemitResponse().apply {
                    statusCode = "IN_PROCESS"
                    uniqueResponseNo = startRemitRequest.uniqueRequestNo
                }
            }
        }
    }
}