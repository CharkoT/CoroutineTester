package kr.co.coroutinetester.ui.main.viewmodel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kr.co.coroutinetester.api.model.MainModel
import kr.co.coroutinetester.util.BaseViewModel

class MainViewModel : BaseViewModel(), ItfGitRepository {

    var etTextSearch = ObservableField<String>("CharkoT")
//    val userList = ObservableField<ArrayList<MainModel>>()
    val userList = MutableLiveData<ArrayList<MainModel>>()

    var title = MutableLiveData<String>("Github search ID")
    var show = MutableLiveData<Boolean>(false)


    val repo = GitRepository.newInstance()

    init {
        viewModelScope.launch {
            Log.d(this.javaClass.name, "MainViewModel >> init setp~~~~")
            repo.userList = userList

            repo.itfGitRepository = this@MainViewModel
        }
    }

    fun onSearchClick() {
        Log.d(this.javaClass.name, "MainViewModel >> onSearchClick setp~~~~")
        val txt = etTextSearch.get()
        if (txt != null) {
            getName(txt)
        }
    }

    fun getName(q: String) {
        title.value = "Searching....."
        repo.getNickname(q)
        show.value = true
    }

    override fun onGetItems() {
        show.value = false
        title.value = "Search success!!"
    }

    override fun onFailItems() {
        show.value = false
        title.value = "Search fail - Unknown "
    }
}
