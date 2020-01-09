package kr.co.coroutinetester.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import kr.co.coroutinetester.api.model.MainApiModel
import kr.co.coroutinetester.api.model.MainModel
import kr.co.coroutinetester.retrofit.RetrofitManager
import kr.co.coroutinetester.retrofit.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitRepository(
	val userList: MutableLiveData<ArrayList<MainModel>>,
	val title: MutableLiveData<String>,
	val show: MutableLiveData<Boolean>
) {
	var retrofit: RetrofitManager

	companion object {
		fun newInstance(
			userList: MutableLiveData<ArrayList<MainModel>>,
			title: MutableLiveData<String>,
			show: MutableLiveData<Boolean>
		) = GitRepository(userList, title, show)
	}

	init {
		Log.d(this.javaClass.name, "GitRepository init setp~~~~")
		retrofit = RetrofitService.getInstance()
	}

	fun getNickName(q: String) {
		title.value = "Searching....."
		show.value = true

		retrofit.getNickName(q).enqueue(object : Callback<MainApiModel> {
			override fun onFailure(call: Call<MainApiModel>, t: Throwable) {

				Log.d(this.javaClass.name, "GitRepository get NickName fail")
				t.stackTrace

				show.value = false
				title.value = "Search fail!!"
			}

			override fun onResponse(call: Call<MainApiModel>, response: Response<MainApiModel>) {
				val model = response.body()?.items
				if (model != null) {
					userList.postValue(model)

					Log.d(this.javaClass.name, "GitRepository get NickName success size ${model.size}")
				}

				show.value = false
				title.value = "Search success!!"
			}
		})
	}
}