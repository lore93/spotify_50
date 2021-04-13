package com.example.lcunial.spotify50.model.data

import com.example.lcunial.spotify50.model.Constants
import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.NotNull
import org.jetbrains.annotations.Nullable

class AlbumCover {

    @NotNull
    @SerializedName(Constants.HEIGHT)
    private val heigth: Int = 0

    @Nullable
    @SerializedName(Constants.URL)
    var url: String? = String()

    @NotNull
    @SerializedName(Constants.WIDTH)
    private val width: Int = 0
}