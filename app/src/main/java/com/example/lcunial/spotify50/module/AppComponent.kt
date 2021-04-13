package com.example.lcunial.spotify50.module

import com.example.lcunial.spotify50.model.TracksDataStore
import com.example.lcunial.spotify50.view.main.root.MainActivity
import com.example.lcunial.spotify50.view.main.root.TracksFragment.TracksFragment
import com.example.lcunial.spotify50.view.main.root.TracksFragment.TracksPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, PresenterModule::class,RecyclerViewModule::class, RepositoryModule::class])
interface AppComponent{
    fun inject(target: TracksFragment)
    fun inject(target: TracksDataStore)
    fun inject(target: TracksPresenter)
}