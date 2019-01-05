package com.enzoftware.rssnews.features.main

import com.enzoftware.rssnews.base.BaseMvpPresenter
import com.enzoftware.rssnews.base.BaseView
import com.enzoftware.rssnews.model.Feed

interface MainContract {

    interface Presenter : BaseMvpPresenter<View> {
        fun loadRssFragments()
    }

    interface View : BaseView {
        fun onLoadRssFragments(feeds: List<Feed>)
    }

    /*
    * Presenter interface includes all user actions. (click, swipe, delete etc.)
    * View interface includes all callbacks and UI changes (show loading, populate a list, show connection error etc.)
    * */

}