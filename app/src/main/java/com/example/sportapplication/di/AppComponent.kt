package com.example.sportapplication.di

import com.example.sportapplication.presentation.ViewModelFactory
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    NetworkModule::class,
    CoroutineModule::class,
    DomainModule::class,
    PresentationModule::class
])
interface AppComponent {

    @Component.Factory
    interface Factory{
        fun create(): AppComponent
    }

    fun viewModelsFactory(): ViewModelFactory
}