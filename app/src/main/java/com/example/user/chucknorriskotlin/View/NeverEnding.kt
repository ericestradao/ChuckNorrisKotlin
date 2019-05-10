package com.example.user.chucknorriskotlin.View

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.user.chucknorriskotlin.Model.ChuckNorrisPojo
import com.example.user.chucknorriskotlin.Model.NeverEndingPojo
import com.example.user.chucknorriskotlin.Presenter.Presenter
import com.example.user.chucknorriskotlin.R
import kotlinx.android.synthetic.main.fragment_never_ending.*

class NeverEnding : Fragment(), ViewContract{
    override fun populateData(chuckNorrisPojo: ChuckNorrisPojo?) {
    }
    override fun populateCharacter(chuckNorrisPojo: ChuckNorrisPojo) {
    }

    lateinit var jokeAdapter: JokeAdapter
    lateinit var presenter: Presenter
    lateinit var recyclerView: RecyclerView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_never_ending, container, false)

        presenter = Presenter()
        presenter.getListJoke()

        return view


    }

    override fun populateListJoke(neverEndingPojo: NeverEndingPojo) {
        jokeAdapter = JokeAdapter(neverEndingPojo, context)
        rv_joke_list.setHasFixedSize(true)
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(context)
        rv_joke_list.layoutManager = layoutManager
        jokeAdapter.notifyDataSetChanged()

    }

}
