package com.enzoftware.rssnews.base

open class BasePresenter <V : BaseView> : BaseMvpPresenter<V> {

    var view : V? = null

    override val isAttached: Boolean = this.view != null

    override fun attach(view: V) {
        this.view = view
    }

    override fun detach() {
        this.view = null
    }
}