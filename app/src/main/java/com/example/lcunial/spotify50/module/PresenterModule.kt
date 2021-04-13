package com.example.lcunial.spotify50.module

import com.example.lcunial.spotify50.view.main.root.TracksFragment.TracksFragmentContract
import com.example.lcunial.spotify50.view.main.root.TracksFragment.TracksPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule {

    @Provides
    @Singleton
    fun provideHomepagePresenter(): TracksFragmentContract.Actions =
        TracksPresenter()
}
