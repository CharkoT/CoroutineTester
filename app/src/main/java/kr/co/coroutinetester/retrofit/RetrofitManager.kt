package kr.co.coroutinetester.retrofit

import kr.co.coroutinetester.api.model.MainApiModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitManager {

    @GET("search/users")
    fun getNickName(@Query("q") q: String): Call<MainApiModel>
}