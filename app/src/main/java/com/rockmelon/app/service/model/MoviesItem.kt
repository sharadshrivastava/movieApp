package com.rockmelon.app.service.model

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json

data class MoviesItem(

    @Json(name = "Writers")
    val writers: List<String?>? = null,

    @Json(name = "Stars")
    val stars: String? = null,

    @Json(name = "Plot")
    val plot: String? = null,

    @Json(name = "Rating")
    val rating: String? = null,

    @Json(name = "Director")
    val director: String? = null,

    @Json(name = "Title")
    val title: String? = null,

    @Json(name = "Actors")
    val actors: List<String?>? = null,

    @Json(name = "Studio")
    val studio: String? = null,

    @Json(name = "Copyright")
    val copyright: String? = null,

    @Json(name = "Runtime")
    val runtime: String? = null,

    @Json(name = "Year")
    val year: String? = null,

    @Json(name = "Poster")
    val poster: String? = null,

    @Json(name = "Votes")
    val votes: String? = null,

    @Json(name = "Genre")
    val genre: String? = null
) : Parcelable {

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<MoviesItem> = object : Parcelable.Creator<MoviesItem> {
            override fun createFromParcel(source: Parcel): MoviesItem = MoviesItem(source)
            override fun newArray(size: Int): Array<MoviesItem?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
        ArrayList<String?>().apply { source.readList(this, String::class.java.classLoader) },
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        ArrayList<String?>().apply { source.readList(this, String::class.java.classLoader) },
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeList(writers)
        writeString(stars)
        writeString(plot)
        writeString(rating)
        writeString(director)
        writeString(title)
        writeList(actors)
        writeString(studio)
        writeString(copyright)
        writeString(runtime)
        writeString(year)
        writeString(poster)
        writeString(votes)
        writeString(genre)
    }
}