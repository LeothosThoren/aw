package fr.airweb.news.model.remote.news_model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsItem(

    @Json(name = "date")
    val date: String? = null,

    @Json(name = "dateformated")
    val dateformated: String? = null,

    @Json(name = "nid")
    val nid: Int? = null,

    @Json(name = "type")
    val type: String? = null,

    @Json(name = "title")
    val title: String? = null,

    @Json(name = "picture")
    val picture: String? = null,

    @Json(name = "content")
    val content: String? = null
) : Parcelable