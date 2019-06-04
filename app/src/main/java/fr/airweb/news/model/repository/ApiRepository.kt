package fr.airweb.news.model.repository

import androidx.lifecycle.MutableLiveData
import fr.airweb.news.model.remote.RetrofitClient
import fr.airweb.news.model.remote.news_model.News
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiRepository {

    fun getInstance(): ApiRepository {

        return ApiRepository()
    }


    fun getApiElements(): MutableLiveData<News> {
        val apiData: MutableLiveData<News> = MutableLiveData()
        RetrofitClient().getApiService().getElements()
            .enqueue(object : Callback<News> {

                override fun onFailure(call: Call<News>, t: Throwable) {
                    apiData.postValue(null)
                }

                override fun onResponse(call: Call<News>, response: Response<News>) {
                    apiData.postValue(response.body())
                }

            })
        return apiData
    }
}