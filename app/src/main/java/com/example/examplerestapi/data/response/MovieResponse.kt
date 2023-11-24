package com.example.examplerestapi.data.response

import android.icu.text.CaseMap.Title
import com.google.gson.annotations.SerializedName

data class MovieResponse(

    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("original_language")
    val originalLanguage: String?,
    @SerializedName("original_title")
    val originalTitle: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("popularity")
    val popularity: Float?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("vote_average")
    val voteAvarage: Float?,
    @SerializedName("vote_count")
    val voteCount: Int?
)
