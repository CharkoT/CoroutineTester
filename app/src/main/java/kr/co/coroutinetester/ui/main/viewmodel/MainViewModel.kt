package kr.co.coroutinetester.ui.main.viewmodel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kr.co.coroutinetester.api.model.MainModel
import kr.co.coroutinetester.util.BaseViewModel

class MainViewModel : BaseViewModel(),
    ItfGitRepository {

    val txtSearch = ObservableField<String>("CharkoT")
    val userList = ObservableField<ArrayList<MainModel>>()
    var title = ObservableField<String>("Github search ID")

    var show = ObservableField<Boolean>(false)

    val repo =
        GitRepository.newInstance()

    init {
        viewModelScope.launch {
            Log.d(this.javaClass.name, "MainViewModel >> init setp~~~~")
            repo.userList = userList

            repo.itfGitRepository = this@MainViewModel
        }
    }

    fun onSearchClick() {
        Log.d(this.javaClass.name, "MainViewModel >> onSearchClick setp~~~~")
        val txt = txtSearch.get()
        if(txt != null) {
            getName(txt)
        }

    }

    fun getName(q: String) {
        title.set("Searching.....")
        repo.getNickname(q)
        show.set(true)
    }

    override fun onGetItems() {
        show.set(false)
        title.set("Search success!!")
    }

    override fun onFailItems() {
        show.set(false)
        title.set("Search fail - Unknown ")
    }
}
