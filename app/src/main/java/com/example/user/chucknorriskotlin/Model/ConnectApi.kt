package com.example.user.chucknorriskotlin.Model

import android.app.Application
import com.example.user.chucknorriskotlin.Presenter.Presenter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ConnectApi {

    object RetrofitObject {

        private var ourInstance:Retrofit?=null

        val instance:Retrofit
            get(){
                if(ourInstance==null){
                    ourInstance=Retrofit.Builder()
                            .baseUrl("http://api.icndb.com/jokes/")
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()
                }
                return ourInstance!!
            }

    }
}


