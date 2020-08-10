package com.example.leagueoflegends.model

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/* middle image */
const val BASE_LOADING_URL = "http://ddragon.leagueoflegends.com/cdn/img/champion/loading/"
/* full image */
const val BASE_SPLASH_URL = "http://ddragon.leagueoflegends.com/cdn/img/champion/splash/"
/* small image */
const val BASE_SQUARE_URL = "http://ddragon.leagueoflegends.com/cdn/10.15.1/img/champion"

data class Champions(
    @SerializedName("data")
    val `data`: Map<String,Champion>,
    @SerializedName("format")
    val format: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("version")
    val version: String
)

@Parcelize
@Entity(primaryKeys = ["id"])
data class Champion(
    @SerializedName("blurb")
    val blurb: String,
    @SerializedName("id")
    val id: String,
    @Embedded
    @SerializedName("image")
    val image:Image,
    @Embedded
    @SerializedName("info")
    val info: Info,
    @SerializedName("key")
    val key: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("partype")
    val partype: String,
    @Embedded
    @SerializedName("stats")
    val stats:Stats,
    @SerializedName("tags")
    val tags: List<String>,
    @SerializedName("title")
    val title: String,
    @SerializedName("version")
    val version: String
) : Parcelable {
    @Parcelize
    data class Image(
        @SerializedName("full")
        val full: String,
        @SerializedName("sprite")
        val sprite: String,
        @SerializedName("group")
        val group: String,
        @SerializedName("x")
        val x: Int,
        @SerializedName("y")
        val y: Int,
        @SerializedName("w")
        val w: Int,
        @SerializedName("h")
        val h: Int
    ) : Parcelable

    @Parcelize
    data class Info(
        @SerializedName("attack")
        val attack: Int,
        @SerializedName("defense")
        val defense: Int,
        @SerializedName("difficulty")
        val difficulty: Int,
        @SerializedName("magic")
        val magic: Int
    ) : Parcelable

    @Parcelize
    data class Stats(
        @SerializedName("hp")
        val hp: Double,
        @SerializedName("hpperlevel")
        val hpperlevel: Double,
        @SerializedName("mp")
        val mp: Double,
        @SerializedName("mpperlevel")
        val mpperlevel: Double,
        @SerializedName("movespeed")
        val movespeed: Double,
        @SerializedName("armor")
        val armor: Double,
        @SerializedName("armorperlevel")
        val armorperlevel: Double,
        @SerializedName("spellblock")
        val spellblock: Double,
        @SerializedName("spellblockperlevel")
        val spellblockperlevel: Double,
        @SerializedName("attackrange")
        val attackrange: Double,
        @SerializedName("hpregen")
        val hpregen: Double,
        @SerializedName("hpregenperlevel")
        val hpregenperlevel: Double,
        @SerializedName("mpregen")
        val mpregen: Double,
        @SerializedName("mpregenperlevel")
        val mpregenperlevel: Double,
        @SerializedName("crit")
        val crit: Double,
        @SerializedName("critperlevel")
        val critperlevel: Double,
        @SerializedName("attackdamage")
        val attackdamage: Double,
        @SerializedName("attackdamageperlevel")
        val attackdamageperlevel: Double,
        @SerializedName("attackspeedperlevel")
        val attackspeedperlevel: Double,
        @SerializedName("attackspeed")
        val attackspeed: Double
    ) : Parcelable

    fun loadingImageUrl() = "$BASE_LOADING_URL${id}_0.jpg"

    fun splashImageUrl() = "$BASE_SPLASH_URL${id}_0.jpg"

    fun squareImageUrl() = "$BASE_SQUARE_URL${image.full}"
}

