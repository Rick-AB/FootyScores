package com.example.footyscores.common

object Constants {
    const val BASE_URL = "https://api-football-v1.p.rapidapi.com/v3/"
    const val RAPID_API_HOST = "api-football-v1.p.rapidapi.com"
    const val NOT_START = "NS"
    const val FULL_TIME = "FT"
    const val HALF_TIME = "HT"
    const val LIVE = "LIVE"
    const val FIRST_HALF = "1H"
    const val SECOND_HALF = "2H"
    const val EXTRA_TIME = "ET"
    const val AFTER_EXTRA_TIME = "AET"
    const val GOAL_EVENT = "goal"
    const val CARD_EVENT = "card"
    const val YELLOW_CARD_EVENT = "yellow card"
    const val RED_CARD_EVENT = "red card"
    const val OWN_GOAL_EVENT = "own goal"
    const val PENALY_SCORED_EVENT = "penalty"
    val eventsOfInterestList = listOf("Goal", "Card")
    val leaguesOfInterestList =
        listOf(39, 40, 140, 141, 135, 136, 78, 79, 61, 62)// ids gotten from api response
    val cupsOfInterestList = listOf(547, 4, 15, 2, 45, 48, 528, 547, 3, 6, 9, 137, 556, 143)
}