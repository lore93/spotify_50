package com.example.lcunial.spotify50.module

import android.content.Context
import dagger.Module
import dagger.Provides
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.LinearLayoutManager
import javax.inject.Singleton


@Module
class RecyclerViewModule{
    @Singleton
    @Provides
    fun providesLayoutManager(context: Context): RecyclerView.LayoutManager {
        return LinearLayoutManager(context)
    }
}