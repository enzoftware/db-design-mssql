package com.enzoftware.rssnews.ui

interface BaseMvpPresenter <V : BaseView>{

    // True if View is attached to presenter
    val isAttached : Boolean

    // CALLED WHEN VIEW ATTACHED TO PRESENTER
    fun attach(view: V)

    // CALL WHEN IS DETACH FROM PRESENTER
    fun detach()

}