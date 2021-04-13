package com.example.lcunial.spotify50.model.data

import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.Nullable

class Item
{
    @Nullable
    @SerializedName("track")
    var track: Track? = Track()
}