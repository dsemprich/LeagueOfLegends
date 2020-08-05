package com.example.leagueoflegends.util

import com.example.leagueoflegends.model.Champion
import io.mockk.mockk

object MockUtil {

    fun mockChampion() = Champion(
        "Once honored defenders of Shurima against the Void, Aatrox and his brethren would eventually become an even greater threat to Runeterra, and were defeated only by cunning mortal sorcery. But after centuries of imprisonment, Aatrox was the first to find...",
        "Aatrox",
        Champion.Image("Aatrox.png", "champion0.png","champion", 0, 0, 48, 48),
        Champion.Info(attack = 8, defense = 4, magic = 3, difficulty = 4),
        "266",
        "Aatrox",
        "Blood Well",
        Champion.Stats(
            580.0,
            90.0,
            0.0,
            0.0,
            345.0,
            38.0,
            3.25,
            32.1,
            1.25,
            175.0,
            3.0,
            1.0,
            0.0,
            0.0,
            0.0,
            0.0,
            60.0,
            5.0,
            2.5,
            0.651
        ),
        listOf("Fighter","Tank"),
        "the Darkin Blade",
        "10.15.1"
    )

    fun mockChampionsMap() = mapOf(Pair("Aatrox", mockChampion()))

}