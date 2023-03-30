{
    "id": "1113675850",
    "jsonrpc": "2.0",
    "method": "create",
    "params": {
        "request": {
            "beneficiary": {
                "additionalInfo": {
                    "businessRegistrationType": "",
                    "legalRepAddress": {
                        "city": "shanghai",
                        "countryCode": "IL",
                        "postcode": "200120",
                        "state": "shanghai",
                        "streetAddress": "shshsshshshsh, shshshshshssh"
                    },
                    "legalRepEmail": "",
                    "legalRepIdType": "",
                    "legalRepMobileNumber": "",
                    "legalRepNationality": "",
                    "legalRepOccupation": "",
                    "personalNationality": "",
                    "personalOccupation": ""
                },
                "address": {
                    "city": "shanghai",
                    "countryCode": "IL",
                    "postcode": "200120",
                    "state": "shanghai",
                    "streetAddress": "shshs__shshshsh, shshshshshssh"
                },
                "bankDetails": {
                    "accountCurrency": "ILS",
                    "accountName": "Jerusalem",
                    "accountNumber": "IL620108000000099999999",
                    "bankAccountType": "BUSINESS",
                    "bankCountryCode": "IL",
                    "bankName": "BANK OF ISRAEL",
                    "swiftCode": "ISRAILIJXXX",
                    "accountRoutingType1": "bank_code",
                    "accountRoutingValue1": "HDFC0000001"
                },
                "companyName": "DHABI LOCAL 2B",
                "entityType": "COMPANY",
                "openId":"AABBCC"
            },
            "cmSpec": "DEFAULT",
            "debitAccount": {
                "accountCurrency": "USA",
                "accountName": "test Technology Joint Stock Company",
                "accountNumber": "IL620108000000099999992",
                "accountRoutingType1": "bank_code",
                "accountRoutingValue1": "01302001",
                "bankAccountType": "BUSINESS",
                "bankCountryCode": "US",
                "bankName": "LA Maritime Commercial Joint Stock Bank",
                "id": "0b4be522-722f-4e61-bf67-06e98d3c340a",
                "swiftCode": "MCOBVNVX"
            },
            "disbursementSettleMode": "GUARANTEE_RECEIVABLEY",
            "feeAccount": {
                "accountCurrency": "USA",
                "accountName": "test Technology Joint Stock Company",
                "accountNumber": "FAKE11001370699726USD",
                "accountRoutingType1": "bank_code",
                "accountRoutingValue1": "01302001",
                "bankAccountType": "BUSINESS",
                "bankCountryCode": "US",
                "bankName": "LA Maritime Commercial Joint Stock Bank",
                "id": "0b4be522-722f-4e61-bf67-06e98d3c340a",
                "swiftCode": "MCOBVNVX"
            },
            "messageToBeneficiary": "c+p test",
            "metadata": {
                "accountId": "c3a83075-4048-4204-8ca6-c57b58fbf2e4",
                "isManual": "false",
                "paidTime": "2020-05-14T06:52:21.381+0000",
                "paymentAlwaysExecute": "false",
                "paymentDateCheck": "false",
                "payoutOrderId": "351b7554-e46a-40c5-93a6-9a7d98194065",
                "stepIdx": "7"
            },
            "mhId": "JPMorganUK-AWXUK",
            "payer": {
                "additionalInfo": {
                    "businessIncorporationDate": "1980-01-01",
                    "businessRegistrationNumber": "CN-000000",
                    "businessRegistrationType": "COMPANY"
                },
                "address": {
                    "city": "shanghai",
                    "countryCode": "US",
                    "postcode": "SH-09090",
                    "state": "shanghai",
                    "streetAddress": "shanghai__shanghai, Shanghai"
                },
                "companyName": "dean staging123 Limited",
                "entityType": "COMPANY"
            },
            "paymentMethod": "LOCAL_TRANSFER",
            "paymentReason": "travel",
            "paymentRoutingInfo": {
                "swiftChargeOption": "SHARED"
            },
            "reference": "{\"orderId\":\"50ff4964-5348-425e-b136-b7470fc99f58\"}",
            "rpcMode": "Async",
            "sourceCurrencyCode": "USD",
            "targetAmount": 100000,
            "targetCurrencyCode": "ILS",
            "uniqueRequestId": "${id}",
            "upstreamSystem": "PAYOUT_ORDER"
        }
    }
}