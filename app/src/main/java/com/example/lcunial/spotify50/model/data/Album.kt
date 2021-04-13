package com.example.lcunial.spotify50.model.data

import com.example.lcunial.spotify50.model.Constants
import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.NotNull
import org.jetbrains.annotations.Nullable

class Album {

    @Nullable
    @SerializedName(Constants.NAME)
    var albumName: String? = String()

    @NotNull
    @SerializedName(Constants.IMAGES)
    var trackImages: List<AlbumCover>? = listOf()

}