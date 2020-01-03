package kr.co.coroutinetester.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kr.co.coroutinetester.api.model.MainModel
import kr.co.coroutinetester.util.BaseViewModel

class MainViewModel : BaseViewModel() {

	private var _title = MutableLiveData<String>("Github search ID")
	private var _show = MutableLiveData<Boolean>(false)
	private var _userList = MutableLiveData<ArrayList<MainModel>>()

	var etTextSearch = MutableLiveData<String>("CharkoT")
	var title: LiveData<String> = _title
	var show: LiveData<Boolean> = _show
	var userList: LiveData<ArrayList<MainModel>> = _userList

	val repo = GitRepository.newInstance()

	init {
		viewModelScope.launch {
			Log.d(this.javaClass.name, "MainViewModel >> init setp~~~~")
//			repo.itfGitRepository = this@MainViewModel
			val getNick = repo.retrofit.getNickName(etTextSearch.value.let { it.toString() }).await()
			_userList.postValue(getNick.items)
		}
	}

	fun onSearchClick() {
		Log.d(this.javaClass.name, "MainViewModel >> onSearchClick setp~~~~")
		val txt = etTextSearch.value
		if (txt != null) {
			getName(txt)
		}
	}

	fun getName(q: String) {
		viewModelScope.launch {
			_title.value = "Searching....."
			_show.value = true

			val getNick = repo.retrofit.getNickName(q).await()
			_userList.postValue(getNick.items)

			_show.value = false
			_title.value = "Search success!!"

		}
	}

//	override fun onGetItems() {
//		_show.value = false
//		_title.value = "Search success!!"
//	}
//
//	override fun onFailItems() {
//		_show.value = false
//		_title.value = "Search fail - Unknown "
//	}
}
