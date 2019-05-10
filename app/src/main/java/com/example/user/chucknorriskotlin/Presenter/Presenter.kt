package com.example.user.chucknorriskotlin.Presenter

import android.nfc.Tag
import android.util.Log
import com.example.user.chucknorriskotlin.MainActivity
import com.example.user.chucknorriskotlin.Model.ChuckNorrisInterface
import com.example.user.chucknorriskotlin.Model.ChuckNorrisPojo
import com.example.user.chucknorriskotlin.Model.ConnectApi
import com.example.user.chucknorriskotlin.Model.NeverEndingPojo
import com.example.user.chucknorriskotlin.View.ViewContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Presenter : PresenterContract {

  //  private val TAG = Presenter()::class.java.simpleName

    internal var viewContract: ViewContract = null

    public Presenter(viewContract: ViewContract) {
        this.viewContract = viewContract
    }


    override fun getRandomJoke() {
        val retrofit = ConnectApi.RetrofitObject.instance
        val chuckNorrisInterface = retrofit.create(ChuckNorrisInterface::class.java) //create(ChuckNorrisApiInterface::class.java!!)
        chuckNorrisInterface.getJokes().enqueue(object : Callback<ChuckNorrisPojo>{

            override fun onResponse(call: Call<ChuckNorrisPojo>, response: Response<ChuckNorrisPojo>) {
                viewContract!!.populateData(response.body())
            }

            override fun onFailure(call: Call<ChuckNorrisPojo>, t: Throwable) {
                Log.d("*****", "Ains!")
            }
        })
    }

    override fun getCharacter(firstName: Array<String>, lastName: Array<String>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getListJoke() {
        val retrofit = ConnectApi.RetrofitObject.instance
        val chuckNorrisInterface = retrofit.create(ChuckNorrisInterface::class.java) //create(ChuckNorrisApiInterface::class.java!!)
        chuckNorrisInterface.getList().enqueue(object : Callback<NeverEndingPojo>{

            override fun onResponse(call: Call<NeverEndingPojo>, response: Response<NeverEndingPojo>) {
                response.body()?.let { viewContract?.populateListJoke(it) }

            }

            override fun onFailure(call: Call<NeverEndingPojo>, t: Throwable) {

            }
        })

    }
}