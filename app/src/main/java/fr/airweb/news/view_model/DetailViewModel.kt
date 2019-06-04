package fr.airweb.news.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailViewModel : ViewModel() {
    private val itemNewsTitle = MutableLiveData<String>()
    private val itemNewsContent = MutableLiveData<String>()
    private val itemNewsPicture = MutableLiveData<String>()

    fun getTitle(): MutableLiveData<String> {
        return itemNewsTitle
    }

    fun getContent(): MutableLiveData<String> {
        return itemNewsContent
    }

    fun getPicture(): MutableLiveData<String> {
        return itemNewsPicture
    }
}