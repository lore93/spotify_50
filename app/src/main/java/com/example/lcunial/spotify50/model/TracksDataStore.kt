package com.example.lcunial.spotify50.model

import android.content.Context
import com.example.lcunial.spotify50.application.App
import com.example.lcunial.spotify50.model.db.Track
import io.reactivex.Single
import javax.inject.Inject

abstract class TracksDataStore {
    @Inject lateinit var context: Context
    init {
        App.getComponent().inject(this)
    }
    abstract fun tracksList(): Single<List<Track>>?
}