package com.example.sportapplication.di

import com.example.sportapplication.data.repository.CountryRepositoryImpl
import com.example.sportapplication.data.repository.LeagueRepositoryImpl
import com.example.sportapplication.data.repository.MatchRepositoryImpl
import com.example.sportapplication.data.repository.StandingRepositoryImpl
import com.example.sportapplication.data.repository.TeamRepositoryImpl
import com.example.sportapplication.domain.repository.CountryRepository
import com.example.sportapplication.domain.repository.LeagueRepository
import com.example.sportapplication.domain.repository.MatchRepository
import com.example.sportapplication.domain.repository.StandingRepository
import com.example.sportapplication.domain.repository.TeamRepository
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {

    @Binds
    fun provideCountryRepository(repository: CountryRepositoryImpl): CountryRepository

    @Binds
    fun provideLeagueRepository(repository: LeagueRepositoryImpl): LeagueRepository

    @Binds
    fun provideMatchRepository(repository: MatchRepositoryImpl): MatchRepository

    @Binds
    fun provideStandingRepository(repository: StandingRepositoryImpl): StandingRepository

    @Binds
    fun provideTeamRepository(repository: TeamRepositoryImpl): TeamRepository
}