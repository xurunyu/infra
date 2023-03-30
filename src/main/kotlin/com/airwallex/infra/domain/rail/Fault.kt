package com.airwallex.infra.domain.rail

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "Fault")
@XmlAccessorType(XmlAccessType.FIELD)
class StatusResponseFault {
    @XmlElement(name = "Code")
    lateinit var code: FaultCode

    @XmlElement(name = "Reason")
    lateinit var reason: FaultReason
}

@XmlRootElement(name = "Code")
@XmlAccessorType(XmlAccessType.FIELD)
class FaultCode {

    @XmlElement(name = "Value")
    var value: String? = null

    @XmlElement(name = "Subcode")
    var subCode: FaultSubCode? = null
}

@XmlRootElement(name = "Code")
@XmlAccessorType(XmlAccessType.FIELD)
class FaultSubCode {
    @XmlElement(name = "Value")
    var value: String? = null

    @XmlElement(name = "Subcode")
    var subCode: FaultSubCode? = null
}

@XmlRootElement(name = "Reason")
@XmlAccessorType(XmlAccessType.FIELD)
class FaultReason {

    @XmlElement(name = "Text")
    var text: String? = null
}
