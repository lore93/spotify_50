package com.example.lcunial.spotify50.application

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import com.example.lcunial.spotify50.module.AppComponent
import com.example.lcunial.spotify50.module.AppModule
import com.example.lcunial.spotify50.module.DaggerAppComponent
import com.example.lcunial.spotify50.module.PresenterModule


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = initDagger(this)
        application=this
    }

    private fun initDagger(app: App): AppComponent =
        DaggerAppComponent.builder()
            .appModule(AppModule(app))
            .build()

    companion object {

        lateinit var appComponent: AppComponent

        private var application: Application? = null

        fun isNetworkConnected(): Boolean {
            val cm = application?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            return cm.activeNetworkInfo != null
        }

        fun getComponent() : AppComponent{
            return appComponent
        }
    }


}