package com.example.sportapplication

import android.app.Application
import com.example.sportapplication.di.AppComponent
import com.example.sportapplication.di.DaggerAppComponent
import com.onesignal.OneSignal

const val ONESIGNAL_APP_ID = "24f7b858-4e81-4d8a-9e62-2b731fe9ce7e"
class SportApplication: Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create()
    }

    override fun onCreate() {
        super.onCreate()

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)

//        OneSignal.promptForPushNotifications()
    }
}