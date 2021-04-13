package com.example.lcunial.spotify50.model.api

import com.example.lcunial.spotify50.model.Constants
import com.example.lcunial.spotify50.model.data.Items
import io.reactivex.Observable
import retrofit2.http.GET

interface SpotifyService {

    @GET(Constants.GLOBAL_TOP_50_TRACKS)
    fun getItems() : Observable<Items>
}
