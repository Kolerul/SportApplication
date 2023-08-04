package com.example.sportapplication.di

import androidx.lifecycle.ViewModel
import com.example.sportapplication.presentation.viewmodel.CountryViewModel
import com.example.sportapplication.presentation.viewmodel.LeagueViewModel
import com.example.sportapplication.presentation.viewmodel.MatchesViewModel
import com.example.sportapplication.presentation.viewmodel.TeamViewModel
import com.example.sportapplication.presentation.viewmodel.WebViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface PresentationModule {

    @Binds
    @IntoMap
    @ViewModelKey(MatchesViewModel::class)
    fun provideMatchesViewModel(viewModel: MatchesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CountryViewModel::class)
    fun provideCountryViewModel(viewModel: CountryViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LeagueViewModel::class)
    fun provideLeagueViewModel(viewModel: LeagueViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(WebViewModel::class)
    fun provideWebViewModel(viewModel: WebViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TeamViewModel::class)
    fun provideTeamViewModel(viewModel: TeamViewModel): ViewModel
}