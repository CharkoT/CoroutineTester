package kr.co.coroutinetester.retrofit

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService private constructor() {

    init {
        Log.d(this.javaClass.name, "RetrofitService init setp~~~~")
    }

    companion object {
        fun getInstance(): RetrofitManager {
            return Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitManager::class.java)
        }
    }

}