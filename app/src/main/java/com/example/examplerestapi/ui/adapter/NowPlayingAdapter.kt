package com.example.examplerestapi.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examplerestapi.R
import com.example.examplerestapi.data.response.MovieResponse
import com.squareup.picasso.Picasso

class NowPlayingAdapter(private val listMovie: List<MovieResponse>) : RecyclerView.Adapter<NowPlayingAdapter.NowPlayingHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NowPlayingHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_now_playing, parent, false)
        return NowPlayingHolder(view)
    }

    override fun onBindViewHolder(holder: NowPlayingHolder, position: Int) {
        holder.bindView(listMovie[position])
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }

    inner class NowPlayingHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bindView(movie: MovieResponse){
            // inisiasi view nya
            val imgPoster = view.findViewById<ImageView>(R.id.imgPoster)
            val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
            val tvRating = view.findViewById<TextView>(R.id.tvRating)
            val tvOverview = view.findViewById<TextView>(R.id.tvOverview)

            tvTitle.text = movie.title
            tvRating.text = "${movie.voteAvarage}" // ini tipe datanya float biar jadi string dibuat kaya gini
            tvOverview.text = movie.overview

            val path = buildPosterPath(movie.posterPath)

            Picasso.get().load(path).into(imgPoster)
        }

        private fun buildPosterPath(posterPath: String?): String {
            return "https://image.tmdb.org/t/p/w500/$posterPath"
        }
    }

}