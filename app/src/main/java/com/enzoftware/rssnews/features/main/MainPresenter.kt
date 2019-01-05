package com.enzoftware.rssnews.features.main

import com.enzoftware.rssnews.base.BasePresenter
import com.enzoftware.rssnews.di.service.RssService
import java.util.*
import javax.inject.Inject


class MainPresenter @Inject constructor(val repository: MainRepository) : BasePresenter<MainContract.View>(),
    MainContract.Presenter {

    override fun loadRssFragments() {
        view?.onLoadRssFragments(repository.parseFeeds())
    }

}