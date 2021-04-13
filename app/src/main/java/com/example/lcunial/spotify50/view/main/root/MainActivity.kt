package com.example.lcunial.spotify50.view.main.root

import android.app.Activity
import android.os.Bundle
import com.example.lcunial.spotify50.R


class MainActivity : Activity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {}
}