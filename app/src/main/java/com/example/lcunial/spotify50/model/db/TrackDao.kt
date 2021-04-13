package com.example.lcunial.spotify50.model.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Single

@Dao
interface TrackDao {
    @Query("SELECT * FROM track")
    fun getAll(): Single<List<Track>>


    @Insert
    fun insertAll(vararg tracks: Track)

    @Delete
    fun delete(track: Track)
}