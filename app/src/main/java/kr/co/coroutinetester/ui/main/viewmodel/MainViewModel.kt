package kr.co.coroutinetester.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kr.co.coroutinetester.api.model.MainModel
import kr.co.coroutinetester.util.BaseViewModel

class MainViewModel : BaseViewModel() {

	private var _title = MutableLiveData<String>("Github search ID")
	private var _show = MutableLiveData<Boolean>(false)
	private var _userList = SearchNickLiveData<ArrayList<MainModel>>()

	val repo = GitRepository.newInstance(_userList, _title, _show)

	var etTextSearch = MutableLiveData<String>("CharkoT")
	var title: LiveData<String> = _title
	var show: LiveData<Boolean> = _show

	var userList: LiveData<ArrayList<MainModel>> = _userList

	init {
		viewModelScope.launch {
			Log.d(this.javaClass.name, "MainViewModel >> init setp~~~~")
		}
	}

	fun onSearchClick() {
		Log.d(this.javaClass.name, "MainViewModel >> onSearchClick setp~~~~")

		getQuery()
	}

	fun getQuery() {

		val query = etTextSearch.value.let { it.toString() }
		if (query.length > 0) {
			repo.getNickName(query)
		}
	}

	inner class SearchNickLiveData<T>() : MutableLiveData<T>() {
		override fun onActive() {
			super.onActive()

			getQuery()
		}
	}
}