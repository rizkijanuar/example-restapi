package com.example.examplerestapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examplerestapi.R
import com.example.examplerestapi.data.api.Network
import com.example.examplerestapi.data.response.MovieResponse
import com.example.examplerestapi.ui.adapter.NowPlayingAdapter
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: NowPlayingAdapter
    private var listMovie = mutableListOf<MovieResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvNowPlaying = findViewById<RecyclerView>(R.id.rvNowPlaying)
        rvNowPlaying.layoutManager = LinearLayoutManager(this)
        adapter = NowPlayingAdapter(listMovie)
        rvNowPlaying.adapter = adapter


        lifecycleScope.launch {
            val result = Network.getService(this@MainActivity).getNowPlaying(
                token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxZTZhMTViZDdjMGNkMDFiM2Y2M2M3Zjc1NGQyMzJhZSIsInN1YiI6IjY1MjRkMjMxYjAwNDBhMDEzYTE0NTU5MCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.AztZWX2ZfCYkqUmuXNmvGcny5pOoJJ3xgdIvGhshbb8",
                lang = "en-US",
                page = 1,
                region = "US"
            )
            result.results.map {
                Log.d("debug", "hasilnya : ${it}")
                listMovie.add(it)
            }

            // update recyclerviewnya
            adapter.notifyDataSetChanged()
        }

    }
}