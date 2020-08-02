package com.example.leagueoflegends.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


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
) {
    data class Image(
        @SerializedName("full")
        val full: String,
        @SerializedName("group")
        val group: String,
        @SerializedName("h")
        val h: Int,
        @SerializedName("sprite")
        val sprite: String,
        @SerializedName("w")
        val w: Int,
        @SerializedName("x")
        val x: Int,
        @SerializedName("y")
        val y: Int
    )

    data class Info(
        @SerializedName("attack")
        val attack: Int,
        @SerializedName("defense")
        val defense: Int,
        @SerializedName("difficulty")
        val difficulty: Int,
        @SerializedName("magic")
        val magic: Int
    )

    data class Stats(
        @SerializedName("armor")
        val armor: Double,
        @SerializedName("armorperlevel")
        val armorperlevel: Double,
        @SerializedName("attackdamage")
        val attackdamage: Double,
        @SerializedName("attackdamageperlevel")
        val attackdamageperlevel: Double,
        @SerializedName("attackrange")
        val attackrange: Double,
        @SerializedName("attackspeed")
        val attackspeed: Double,
        @SerializedName("attackspeedperlevel")
        val attackspeedperlevel: Double,
        @SerializedName("crit")
        val crit: Double,
        @SerializedName("critperlevel")
        val critperlevel: Double,
        @SerializedName("hp")
        val hp: Double,
        @SerializedName("hpperlevel")
        val hpperlevel: Double,
        @SerializedName("hpregen")
        val hpregen: Double,
        @SerializedName("hpregenperlevel")
        val hpregenperlevel: Double,
        @SerializedName("movespeed")
        val movespeed: Double,
        @SerializedName("mp")
        val mp: Double,
        @SerializedName("mpperlevel")
        val mpperlevel: Double,
        @SerializedName("mpregen")
        val mpregen: Double,
        @SerializedName("mpregenperlevel")
        val mpregenperlevel: Double,
        @SerializedName("spellblock")
        val spellblock: Double,
        @SerializedName("spellblockperlevel")
        val spellblockperlevel: Double
    )
}

