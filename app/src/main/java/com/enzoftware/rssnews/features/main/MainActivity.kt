package com.enzoftware.rssnews.features.main

import android.os.Bundle
import com.enzoftware.rssnews.R
import com.enzoftware.rssnews.base.BaseActivity
import com.enzoftware.rssnews.di.component.ActivityComponent
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {

    @Inject
    private lateinit var presenter : MainContract.Presenter

    override val layoutResource: Int = R.layout.activity_main
    private lateinit var wrapper: ChromeTabsWrapper

    override fun init(state: Bundle?) {
        presenter = MainPresenter()
        presenter.attach(this)
        presenter.loadHelloText()
        textViewHello.setOnClickListener {
            presenter.loadHelloText()
        }
    }

    override fun inject(component: ActivityComponent) {
        component.inject(this)
    }

    override fun onTextLoaded(text: String) {
        textViewHello.text = text
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }
}
