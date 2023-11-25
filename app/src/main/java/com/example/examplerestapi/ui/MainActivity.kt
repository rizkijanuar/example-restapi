package com.example.examplerestapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import com.example.examplerestapi.R
import com.example.examplerestapi.data.api.Network
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.btnReq)

        button.setOnClickListener {
            lifecycleScope.launch {
                val result = Network.getService(this@MainActivity).getNowPlaying(
                    token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxZTZhMTViZDdjMGNkMDFiM2Y2M2M3Zjc1NGQyMzJhZSIsInN1YiI6IjY1MjRkMjMxYjAwNDBhMDEzYTE0NTU5MCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.AztZWX2ZfCYkqUmuXNmvGcny5pOoJJ3xgdIvGhshbb8",
                    lang = "en-US",
                    page = 1,
                    region = "US"
                )
                result.results.map {
                    Log.d("debug", "hasilnya : ${it}")
                }
            }
        }
    }
}