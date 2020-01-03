package kr.co.coroutinetester.api.model

import kr.co.coroutinetester.api.BaseApi

data class MainApiModel(
	var items: ArrayList<MainModel>? = null
) : BaseApi()