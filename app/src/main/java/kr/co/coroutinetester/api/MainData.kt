package kr.co.coroutinetester.api

import androidx.lifecycle.LiveData
import kr.co.coroutinetester.api.model.MainModel

interface MainData {
	val mainModel: LiveData<ArrayList<MainModel>>

	suspend fun fetchCurrent(
		q: String
	)
}