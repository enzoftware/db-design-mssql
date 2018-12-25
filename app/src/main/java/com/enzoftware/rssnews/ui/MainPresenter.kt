package com.enzoftware.rssnews.ui

import java.util.*


class MainPresenter: BasePresenter<MainContract.View>(),
    MainContract.Presenter {

    private val helloWorldTexts = listOf("HELLO", "WORLD", "RSS", "NEWS")

    override fun loadHelloText() {
        val random = Random()
        val hello = helloWorldTexts[random.nextInt(helloWorldTexts.size)]
        view?.onTextLoaded(hello)
    }
}