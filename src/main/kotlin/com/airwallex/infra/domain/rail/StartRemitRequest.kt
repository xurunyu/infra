package com.airwallex.infra.domain.rail

class StartRemitRequest(
    val uniqueRequestNo: String?,//1-32
    val remitterType: String, //I,C
    val remitterFullName: String,//1,80
    val remitterAddress: RemitterAddress,
    val remitterContact: RemitterContact? = null,
    val beneficiaryType: String,
    val beneficiaryFullName: String,
    val beneficiaryAddress: BeneficiaryAddress? = null,
    val beneficiaryContact: BeneficiaryContact? = null,
    val beneficiaryAccountNo: String,//1,34
    val beneficiaryIFSC: String,//11
    val transferType: TransferType,
    val transferAmount: String,//n.2
    val remitterToBeneficiaryInfo: String,//2,120
    val purposeCode: String,//PC\d{2}
    val accountId: String
)  {
    val version: String = "1.0"
    val partnerCode: String = "AIRWALLEXH"
    val transferCurrencyCode: String = "INR"
}


class RemitterAddress(address: String) : Address(address)

class BeneficiaryAddress(address: String) : Address(address)

class RemitterContact(mobileNo: String?, emailID: String?) : Contact(mobileNo, emailID)

class BeneficiaryContact(mobileNo: String?, emailID: String?) : Contact(mobileNo, emailID)

open class Address(address: String) {
    var addressArray = address.chunked(120)

    var address1 = addressArray[0]

    var address2 = addressArray.elementAtOrNull(1)

    var address3 = addressArray.elementAtOrNull(2)

    var postalCode: String? = null

    var city: String? = null

    var stateOrProvince: String? = null

    var country: String? = null
}

open class Contact(var mobileNo: String?, val emailID: String?)

enum class TransferType {
    NEFT,
    IMPS,
    RTGS,
    FT,
    NA,
    ANY;
}