package com.example.lcunial.spotify50.view.main.login

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.Navigation
import com.example.lcunial.spotify50.R
import com.example.lcunial.spotify50.model.Constants
import com.example.lcunial.spotify50.model.api.SpotifyClient
import com.example.lcunial.spotify50.view.main.root.MainActivity
import com.spotify.sdk.android.authentication.AuthenticationClient
import com.spotify.sdk.android.authentication.AuthenticationRequest
import com.spotify.sdk.android.authentication.AuthenticationResponse
import kotlinx.android.synthetic.main.fragment_tracks.*

class LoginActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        openLoginActivity()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        // Check if result comes from the correct activity
        if (requestCode == Constants.AUTH_TOKEN_REQUEST_CODE) {
            val response = AuthenticationClient.getResponse(resultCode, intent)
            when (response.type) {
                // Response was successful and contains auth token
                AuthenticationResponse.Type.TOKEN -> {
                    SpotifyClient.createClient(response.accessToken)
                }
                // Auth flow returned an error
                AuthenticationResponse.Type.ERROR -> {

                }
                else -> TODO()
            }
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun openLoginActivity() {
        val builder = AuthenticationRequest.Builder(
            Constants.CLIENT_ID, AuthenticationResponse.Type.TOKEN,
            getString(R.string.spotifyCallback))
        builder.setScopes(arrayOf(getString(R.string.streaming)))
        val request = builder.build()
        AuthenticationClient.openLoginActivity(this, Constants.AUTH_TOKEN_REQUEST_CODE, request)
    }
}