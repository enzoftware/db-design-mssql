package com.enzoftware.rssnews.di.module

import android.support.v4.app.FragmentActivity
import com.enzoftware.rssnews.di.scope.ActivityScope
import com.enzoftware.rssnews.di.service.RssService
import com.enzoftware.rssnews.features.main.MainContract
import com.enzoftware.rssnews.features.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule (private val activity: FragmentActivity){

    @Provides
    @ActivityScope
    fun provideMainPresenter(service: RssService): MainContract.Presenter =
        MainPresenter(service)

}