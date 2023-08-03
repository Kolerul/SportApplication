package com.example.sportapplication

import android.app.Application
import com.example.sportapplication.di.AppComponent
import com.example.sportapplication.di.DaggerAppComponent

class SportApplication: Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create()
    }
}