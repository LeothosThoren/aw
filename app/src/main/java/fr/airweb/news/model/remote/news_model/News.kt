package fr.airweb.news.model.remote.news_model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class News(

    @Json(name = "news")
    val news: List<NewsItem?>? = null
): Parcelable