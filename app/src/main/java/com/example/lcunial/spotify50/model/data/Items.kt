package com.example.lcunial.spotify50.model.data

import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.Nullable

class Items {

    @Nullable
    @SerializedName("items")
    var itemsList: List<Item> = listOf()
}