package kr.co.coroutinetester.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import kr.co.coroutinetester.api.model.MainApiModel
import kr.co.coroutinetester.api.model.MainModel
import kr.co.coroutinetester.retrofit.RetrofitManager
import kr.co.coroutinetester.retrofit.RetrofitService

interface ItfGitRepository {
	fun onGetItems()
	fun onFailItems()
}

class GitRepository {

	var userList = MutableLiveData<ArrayList<MainModel>>()
	var itfGitRepository: ItfGitRepository? = null
	var retrofit: RetrofitManager

	companion object {
		fun newInstance() =
			GitRepository()
	}

	init {
		Log.d(this.javaClass.name, "GitRepository init setp~~~~")
		retrofit = RetrofitService.getInstance()
	}

//	fun getNickName(q: String): MainApiModel {
//		return retrofit.getNickName(q)
//	}

//            .enqueue(object : Callback<MainApiModel> {
//            override fun onFailure(call: Call<MainApiModel>, t: Throwable) {
//
//                Log.d(this.javaClass.name, "GitRepository get NickName fail")
//                t.stackTrace
//
//                itfGitRepository?.onFailItems()
//            }
//
//            override fun onResponse(call: Call<MainApiModel>, response: Response<MainApiModel>) {
//                val model = response.body()?.items
//                if (model != null) {
//                    userList.value = (model as ArrayList<MainModel>?)
//                }
//
//                Log.d(
//                    this.javaClass.name,
//                    "GitRepository get NickName success size ${userList?.value?.size}"
//                )
//                itfGitRepository?.onGetItems()
//            }
//
//        })
//	}
}