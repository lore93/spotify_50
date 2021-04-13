package com.example.lcunial.spotify50.model.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "track")
data class Track(
    @PrimaryKey  @ColumnInfo(name = "track_name") var trackName: String,
    @ColumnInfo(name = "album_name") var albumName: String? =null,
    @ColumnInfo(name = "artist_name") var artistName: String? = null,
    @ColumnInfo(name = "cover_url") var albumCoverUrl: String? = null
)