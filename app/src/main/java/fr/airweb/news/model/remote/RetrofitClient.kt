package fr.airweb.news.model.remote

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitClient {

    fun getApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://airweb-demo.airweb.fr")
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create(ApiService::class.java)
    }
}