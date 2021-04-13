package com.example.lcunial.spotify50.view.main.root.TracksFragment

import com.example.lcunial.spotify50.view.main.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class TracksPresenter: TracksFragmentContract.Actions, BasePresenter() {

    override lateinit var view: TracksFragmentContract.View
    @Inject lateinit var getTracksUseCase: GetTracksUseCase

    override fun loadTracks() {
        getTracksUseCase.execute()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(view::setTracksContent, view::displayError)?.let { addDisposable(it) }
    }
}