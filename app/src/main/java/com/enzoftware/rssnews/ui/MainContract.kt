package com.enzoftware.rssnews.ui

interface MainContract {

    interface Presenter : BaseMvpPresenter<View> {
        fun loadHelloText()
    }

    interface View : BaseView {
        fun onTextLoaded(text: String)
    }

    /*
    * Presenter interface includes all user actions. (click, swipe, delete etc.)
    * View interface includes all callbacks and UI changes (show loading, populate a list, show connection error etc.)
    * */

}