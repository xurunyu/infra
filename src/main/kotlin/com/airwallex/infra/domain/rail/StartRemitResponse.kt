package com.airwallex.infra.domain.rail

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "Envelope")
@XmlAccessorType(XmlAccessType.FIELD)
class StartRemitResponse {
    @XmlElement(name = "Body")
    lateinit var body: RemitBody

    fun getResponse(): RemitResponse? {
        return body.remitResponse
    }
}

@XmlRootElement(name = "Body")
@XmlAccessorType(XmlAccessType.FIELD)
class RemitBody {

    @XmlElement(name = "Fault")
    var fault: StatusResponseFault? = null

    @XmlElement(name = "startRemitResponse")
    var remitResponse: RemitResponse? = null
}

@XmlRootElement(name = "startRemitResponse")
@XmlAccessorType(XmlAccessType.FIELD)
class RemitResponse {

    @XmlElement(name = "requestReferenceNo")
    var requestReferenceNo: String? = null

    @XmlElement(name = "uniqueResponseNo")
    var uniqueResponseNo: String? = null

    @XmlElement(name = "attemptNo")
    var attemptNo: String? = null

    @XmlElement(name = "reqTransferType")
    var reqTransferType: String? = null

    @XmlElement(name = "statusCode")
    var statusCode: String = ""

    @XmlElement(name = "subStatusCode")
    var subStatusCode: String? = null

    @XmlElement(name = "subStatusText")
    var subStatusText: String? = null
}