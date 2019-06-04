package fr.airweb.news.model.remote

import fr.airweb.news.model.remote.news_model.News
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/psg/psg.json")
    fun getElements(): Call<News>
}