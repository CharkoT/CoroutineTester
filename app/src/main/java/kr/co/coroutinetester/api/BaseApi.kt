package kr.co.coroutinetester.api

import kr.co.coroutinetester.api.model.ErrorModel

open class BaseApi(
    var message: String? = null,
    var errorModel: ErrorModel? = null,
    var total_count: Int? = null,
    var incomplete_results: Boolean? = null
)