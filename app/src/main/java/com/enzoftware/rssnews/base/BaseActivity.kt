package com.enzoftware.rssnews.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import com.enzoftware.rssnews.NewsApp
import com.enzoftware.rssnews.di.component.ActivityComponent
import com.enzoftware.rssnews.di.component.DaggerActivityComponent
import com.enzoftware.rssnews.di.module.ActivityModule

abstract class BaseActivity : AppCompatActivity(), BaseView {

    @get:LayoutRes
    protected abstract val layoutResource: Int

    abstract fun inject(component: ActivityComponent)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResource)
        inject(DaggerActivityComponent.builder()
            .appComponent(NewsApp.component())
            .activityModule(ActivityModule(this))
            .build())
        init(savedInstanceState)
    }

    protected abstract fun init (state: Bundle?)


}
