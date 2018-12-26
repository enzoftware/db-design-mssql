package com.enzoftware.rssnews.di.component

import com.enzoftware.rssnews.di.scope.ActivityScope
import com.enzoftware.rssnews.di.module.ActivityModule
import com.enzoftware.rssnews.features.main.MainActivity
import com.enzoftware.rssnews.features.main.MainContract
import dagger.Component



@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    fun mainPresenter(): MainContract.Presenter
    fun inject(mainActivity: MainActivity)
}