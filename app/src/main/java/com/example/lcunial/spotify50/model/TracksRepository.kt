package com.example.lcunial.spotify50.model

import com.example.lcunial.spotify50.application.App
import com.example.lcunial.spotify50.model.api.SpotifyClient
import com.example.lcunial.spotify50.model.db.Track
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class TracksRepository {


    fun tracks(): Single<List<Track>>? {
        //Keep tracks online iff the Network is on and the Spotify client is authenticated
        val rp =TracksRepositoryFactory.create(App.isNetworkConnected(),SpotifyClient.getClient()!=null)
        val ob = rp.tracksList()
        if (rp is SpotifyTracksDataStore && ob!=null) {
            //Store tracks to DB after they are downloaded
            ob.subscribeOn(Schedulers.io()).doOnSuccess { DAOTracksDataStore().storeTracksToDB(it) }.subscribe()
        }
        return ob
    }
}
