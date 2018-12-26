package com.enzoftware.rssnews.di.component

import android.app.Application
import com.enzoftware.rssnews.di.service.RssService
import com.enzoftware.rssnews.di.module.AppModule
import com.enzoftware.rssnews.di.module.NetworkModule
import dagger.Component
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {

    fun app(): Application
    fun okHttpClient(): OkHttpClient
    fun retrofit(): Retrofit
    fun service(): RssService
}

