package com.example.user.chucknorriskotlin.View

import com.example.user.chucknorriskotlin.Model.ChuckNorrisPojo
import com.example.user.chucknorriskotlin.Model.NeverEndingPojo

interface ViewContract {
    fun populateData(chuckNorrisPojo: ChuckNorrisPojo?)
    fun populateCharacter(chuckNorrisPojo: ChuckNorrisPojo)
    fun populateListJoke(neverEndingPojo: NeverEndingPojo)
}