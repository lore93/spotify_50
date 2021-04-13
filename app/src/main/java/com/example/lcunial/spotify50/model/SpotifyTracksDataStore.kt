package com.example.lcunial.spotify50.model

import com.example.lcunial.spotify50.model.api.SpotifyClient
import com.example.lcunial.spotify50.model.db.Track
import io.reactivex.Single

class SpotifyTracksDataStore : TracksDataStore() {
    override fun tracksList(): Single<List<Track>>? {
        val ob= Single.fromObservable(SpotifyClient.getClient()?.getSpotifyService()?.getItems()
            ?.map {it.itemsList.map { Track(it.track!!.name!!, it.track!!.album!!.albumName,
                it.track!!.artists!![0].name, it.track!!.album!!.trackImages!![0].url) } })

        return ob

    }
}