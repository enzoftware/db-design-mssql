package com.enzoftware.rssnews

import android.app.Application
import com.enzoftware.rssnews.di.component.AppComponent
import com.enzoftware.rssnews.di.component.DaggerAppComponent
import com.enzoftware.rssnews.di.module.AppModule
import com.squareup.leakcanary.LeakCanary

class NewsApp: Application() {

    companion object {
        private var appComponent: AppComponent? = null

        fun component(): AppComponent{
            return appComponent!!
        }

        fun setComponent(component: AppComponent){
            this.appComponent = component
        }
    }


    override fun onCreate() {
        super.onCreate()
        LeakCanary.install(this)
        setComponent(DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build())
    }
}