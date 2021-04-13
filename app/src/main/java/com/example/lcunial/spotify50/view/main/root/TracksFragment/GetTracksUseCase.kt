package com.example.lcunial.spotify50.view.main.root.TracksFragment


import com.example.lcunial.spotify50.model.TracksRepository
import com.example.lcunial.spotify50.model.db.Track
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class GetTracksUseCase constructor(private val tracksRepository: TracksRepository) {

    fun execute(): Single<List<Track>>? {
        return tracksRepository.tracks()
    }
}