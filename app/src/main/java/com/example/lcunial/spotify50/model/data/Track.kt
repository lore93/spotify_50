package com.example.lcunial.spotify50.model.data

import com.example.lcunial.spotify50.model.Constants
import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.NotNull
import org.jetbrains.annotations.Nullable

class Track ()  {
    @Nullable
    @SerializedName(Constants.NAME)
    var name: String?=String()

    @NotNull
    @SerializedName(Constants.TRACK_NUMBER)
    private val trackNumber: Int = 0

    @Nullable
    @SerializedName(Constants.ALBUM)
    var album: Album? = Album()

    @Nullable
    @SerializedName(Constants.ARTISTS)
    var artists: List<Artist>? = listOf()
}