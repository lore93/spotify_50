package com.example.lcunial.spotify50.model

import com.example.lcunial.spotify50.model.db.AppDatabase
import com.example.lcunial.spotify50.model.db.Track
import io.reactivex.Single
import org.jetbrains.anko.doAsync

class DAOTracksDataStore : TracksDataStore() {
    override fun tracksList(): Single<List<Track>> {
        val db = AppDatabase.getInstance(context)
        return db!!.trackDao().getAll()
    }
    fun storeTracksToDB(tracks: List<Track>) {
        AppDatabase.getInstance(context)?.clearAllTables()
        AppDatabase.getInstance(context)?.trackDao()?.insertAll(*tracks.toTypedArray())
    }
}