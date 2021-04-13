package com.example.lcunial.spotify50.view.main.root.TracksFragment

import com.example.lcunial.spotify50.model.db.Track

interface TracksFragmentContract {

    interface View {
        fun setTracksContent(tracks : List<Track>)
        fun displayError(throwable: Throwable)
    }
    interface Actions {
        var view: View
        fun loadTracks()
    }
}