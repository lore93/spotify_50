package com.example.lcunial.spotify50.model.data

import com.example.lcunial.spotify50.model.Constants
import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.Nullable

class Artist {

    @Nullable
    @SerializedName(Constants.NAME)
    var name: String? = String()
}