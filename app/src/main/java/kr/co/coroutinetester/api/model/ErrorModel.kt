package kr.co.coroutinetester.api.model

data class ErrorModel(
    var resource: String? = null,
    var field: String? = null,
    var code: String? = null
)