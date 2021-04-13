package com.example.lcunial.spotify50.module

import com.example.lcunial.spotify50.model.TracksRepository
import com.example.lcunial.spotify50.view.main.root.TracksFragment.GetTracksUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideTracksRepository(): TracksRepository = TracksRepository()

    @Provides
    @Singleton
    fun getTracksUseCase(tracksRepository: TracksRepository): GetTracksUseCase =
        GetTracksUseCase(tracksRepository)
}