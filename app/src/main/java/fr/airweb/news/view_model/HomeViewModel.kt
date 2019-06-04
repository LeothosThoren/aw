package fr.airweb.news.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.airweb.news.model.remote.news_model.News
import fr.airweb.news.model.repository.ApiRepository

class HomeViewModel : ViewModel() {

    private var apiResponse: MutableLiveData<News>
    private var apiRepository: ApiRepository = ApiRepository()
        .getInstance()

    init {
        apiResponse = apiRepository.getApiElements()
    }

    fun getApiRepository(): LiveData<News> {
        return apiResponse
    }
}