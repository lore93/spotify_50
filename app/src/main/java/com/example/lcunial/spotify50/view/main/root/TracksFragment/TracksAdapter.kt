package com.example.lcunial.spotify50.view.main.root.TracksFragment

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.lcunial.spotify50.R
import com.example.lcunial.spotify50.model.db.Track
import kotlinx.android.synthetic.main.item_track.view.*

class TracksAdapter(private val myDataset: List<Track>) :
    RecyclerView.Adapter<TracksAdapter.MyViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class MyViewHolder(val item: ConstraintLayout) : RecyclerView.ViewHolder(item){
        fun bind(itemView: ConstraintLayout,item: Track){
            itemView.txt_track_title.text = item.trackName
            itemView.txt_track_album.text = item.artistName
            Glide.with(itemView).load(item.albumCoverUrl).into(itemView.im_track)
        }
    }


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyViewHolder {
        // create a new view
        val item = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_track, parent, false) as ConstraintLayout
        // set the view's size, margins, paddings and layout parameters

        return MyViewHolder(item)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
       holder.bind(holder.item,myDataset[position])
    }



    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size
}