package kr.co.coroutinetester.api

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kr.co.coroutinetester.api.model.MainModel
import kr.co.coroutinetester.retrofit.RetrofitManager
import kr.co.coroutinetester.retrofit.RetrofitService
import java.lang.Exception

class MainDataImpl(
	private val service: RetrofitService,
	private val manager: RetrofitManager
) : MainData {

	private val _mainModel = MutableLiveData<ArrayList<MainModel>>()

	override val mainModel: LiveData<ArrayList<MainModel>>
		get() = _mainModel

	override suspend fun fetchCurrent(q: String) {
		try {
			val fetchCurrent = manager.getNickName(q).await()
			_mainModel.postValue(fetchCurrent.items)
		} catch (e: Exception) {
			Log.e("Conntected ", "No internet")
		}
	}
}