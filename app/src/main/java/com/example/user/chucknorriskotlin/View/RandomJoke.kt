package com.example.user.chucknorriskotlin.View

import android.content.ContentValues.TAG
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.user.chucknorriskotlin.Model.ChuckNorrisPojo
import com.example.user.chucknorriskotlin.Model.NeverEndingPojo
import com.example.user.chucknorriskotlin.Presenter.Presenter
import com.example.user.chucknorriskotlin.R

class RandomJoke : Fragment(), ViewContract {
    private lateinit var tv_random: TextView
    internal lateinit var presenter: Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
     val view =inflater!!.inflate(R.layout.fragment_random_joke, container, false)

        presenter = Presenter()
        presenter.getRandomJoke()
        tv_random = view.findViewById(R.id.RandomJoke)

        return view
    }

    override fun populateData(chuckNorrisPojo: ChuckNorrisPojo?) {
        Log.d(TAG, "populateData: ")
        if (chuckNorrisPojo != null) {

            tv_random.text = chuckNorrisPojo.value.joke
        }
    }

    override fun populateCharacter(chuckNorrisPojo: ChuckNorrisPojo) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun populateListJoke(neverEndingPojo: NeverEndingPojo) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
