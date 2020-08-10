package com.example.leagueoflegends.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class ChampionInfo(
    @SerializedName("data")
    val `data`: Map<String, ChampionDetail>,
    @SerializedName("format")
    val format: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("version")
    val version: String
)
    @Entity
    data class ChampionDetail(
            @SerializedName("allytips")
            val allytips: List<String>,
            @SerializedName("blurb")
            val blurb: String,
            @SerializedName("enemytips")
            val enemytips: List<String>,
            @PrimaryKey
            @SerializedName("id")
            val id: String,
            @SerializedName("image")
            val image: Champion.Image,
            @SerializedName("info")
            val info: Champion.Info,
            @SerializedName("key")
            val key: String,
            @SerializedName("lore")
            val lore: String,
            @SerializedName("name")
            val name: String,
            @SerializedName("partype")
            val partype: String,
            @SerializedName("passive")
            val passive: Passive,
            @SerializedName("recommended")
            val recommended: List<Recommended>,
            @SerializedName("skins")
            val skins: List<Skin>,
            @SerializedName("spells")
            val spells: List<Spell>,
            @SerializedName("stats")
            val stats: Stats,
            @SerializedName("tags")
            val tags: List<String>,
            @SerializedName("title")
            val title: String
        ) {

        data class Passive(
                @SerializedName("description")
                val description: String,
                @SerializedName("image")
                val image: Image,
                @SerializedName("name")
                val name: String
            )

        data class Recommended(
            @SerializedName("blocks")
            val blocks: List<Block>,
            @SerializedName("champion")
            val champion: String,
            @SerializedName("customPanel")
            val customPanel: Any,
            @SerializedName("customTag")
            val customTag: String,
            @SerializedName("extensionPage")
            val extensionPage: Boolean,
            @SerializedName("map")
            val map: String,
            @SerializedName("mode")
            val mode: String,
            @SerializedName("sortrank")
            val sortrank: Int,
            @SerializedName("title")
            val title: String,
            @SerializedName("type")
            val type: String,
            @SerializedName("useObviousCheckmark")
            val useObviousCheckmark: Boolean
        ) {
            data class Block(
                @SerializedName("appendAfterSection")
                val appendAfterSection: String,
                @SerializedName("hiddenWithAnyOf")
                val hiddenWithAnyOf: List<String>,
                @SerializedName("hideIfSummonerSpell")
                val hideIfSummonerSpell: String,
                @SerializedName("items")
                val items: List<Item>,
                @SerializedName("maxSummonerLevel")
                val maxSummonerLevel: Double,
                @SerializedName("minSummonerLevel")
                val minSummonerLevel: Double,
                @SerializedName("recMath")
                val recMath: Boolean,
                @SerializedName("recSteps")
                val recSteps: Boolean,
                @SerializedName("showIfSummonerSpell")
                val showIfSummonerSpell: String,
                @SerializedName("type")
                val type: String,
                @SerializedName("visibleWithAllOf")
                val visibleWithAllOf: List<String>
            ) {
                data class Item(
                    @SerializedName("count")
                    val count: Int,
                    @SerializedName("hideCount")
                    val hideCount: Boolean,
                    @SerializedName("id")
                    val id: String
                )
            }
        }

        data class Skin(
                @SerializedName("chromas")
                val chromas: Boolean,
                @SerializedName("id")
                val id: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("num")
                val num: Int
            )

        data class Spell(
            @SerializedName("cooldown")
            val cooldown: List<Double>,
            @SerializedName("cooldownBurn")
            val cooldownBurn: String,
            @SerializedName("cost")
            val cost: List<Double>,
            @SerializedName("costBurn")
            val costBurn: String,
            @SerializedName("costType")
            val costType: String,
            @SerializedName("datavalues")
            val datavalues: Datavalues,
            @SerializedName("description")
            val description: String,
            @SerializedName("effect")
            val effect: List<Any>,
            @SerializedName("effectBurn")
            val effectBurn: List<Any>,
            @SerializedName("id")
            val id: String,
            @SerializedName("image")
            val image: Image,
            @SerializedName("leveltip")
            val leveltip: Leveltip,
            @SerializedName("maxammo")
            val maxammo: String,
            @SerializedName("maxrank")
            val maxrank: Int,
            @SerializedName("name")
            val name: String,
            @SerializedName("range")
            val range: List<Double>,
            @SerializedName("rangeBurn")
            val rangeBurn: String,
            @SerializedName("resource")
            val resource: String,
            @SerializedName("tooltip")
            val tooltip: String,
            @SerializedName("vars")
            val vars: List<Any>
        ) {
            class Datavalues()

            data class Leveltip(
                @SerializedName("effect")
                val effect: List<String>,
                @SerializedName("label")
                val label: List<String>
            )
        }

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
            ) {
            val attackSpeedInt: Int = attackspeed.toInt()
            val attackDamageInt: Int = attackdamage.toInt()
            val armorInt: Int = armor.toInt()
            val hpInt: Int = hp.toInt()
            val moveSpeedInt: Int = movespeed.toInt()
        }
    }


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
)
