package com.enzoftware.rssnews.features.main

import com.enzoftware.rssnews.base.BasePresenter
import com.enzoftware.rssnews.di.service.RssService
import java.util.*
import javax.inject.Inject


class MainPresenter @Inject constructor(val service: RssService) : BasePresenter<MainContract.View>(),
    MainContract.Presenter {

    private val helloWorldTexts = listOf("HELLO", "WORLD", "RSS", "NEWS")

    override fun loadHelloText() {
        val random = Random()
        val hello = helloWorldTexts[random.nextInt(helloWorldTexts.size)]
        view?.onTextLoaded(hello)
    }
}