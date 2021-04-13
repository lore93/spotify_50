package com.example.lcunial.spotify50.model


class TracksRepositoryFactory {

    /**
     * Create [UserDataStore] from a user id.
     */

    companion object {
        fun create(isNetworkConnected : Boolean,isUserAuthenticated : Boolean): TracksDataStore {
            return if(isNetworkConnected && isUserAuthenticated) {
                SpotifyTracksDataStore()
            } else {
                DAOTracksDataStore()
            }
        }
    }
}