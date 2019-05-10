package com.example.user.chucknorriskotlin.Presenter

interface PresenterContract {
    fun getRandomJoke()
    fun getCharacter(firstName: Array<String>, lastName: Array<String>)
    fun getListJoke()
}
