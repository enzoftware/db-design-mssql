package com.enzoftware.rssnews

import android.os.Bundle
import com.enzoftware.rssnews.ui.BaseActivity
import com.enzoftware.rssnews.ui.MainContract
import com.enzoftware.rssnews.ui.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainContract.View {

    private lateinit var presenter : MainContract.Presenter
    override val layoutResource: Int = R.layout.activity_main


    override fun init(state: Bundle?) {
        presenter = MainPresenter()
        presenter.attach(this)
        presenter.loadHelloText()
        textViewHello.setOnClickListener {
            presenter.loadHelloText()
        }
    }

    override fun onTextLoaded(text: String) {
        textViewHello.text = text
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }
}
