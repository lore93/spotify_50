package com.example.lcunial.spotify50.view.main.root.TracksFragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.lcunial.spotify50.R
import com.example.lcunial.spotify50.application.App
import com.example.lcunial.spotify50.model.db.Track
import kotlinx.android.synthetic.main.fragment_tracks.*
import javax.inject.Inject

class TracksFragment : Fragment(),TracksFragmentContract.View {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>

    @Inject lateinit var viewManager: RecyclerView.LayoutManager

    @Inject lateinit var presenter: TracksFragmentContract.Actions

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        App.getComponent().inject(this)

        App.getComponent().inject(presenter as TracksPresenter)

        presenter.view=this

        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_tracks, container, false)
    }

    override fun onStart() {
        super.onStart()
        presenter.loadTracks()
    }

    override fun setTracksContent(tracks : List<Track>) {
        viewAdapter = TracksAdapter(tracks)
        recyclerView = my_recycler_view.apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }
    }

    override fun displayError(throwable: Throwable) {
        Toast.makeText(context, getString(R.string.error), Toast.LENGTH_SHORT).show()
    }

}