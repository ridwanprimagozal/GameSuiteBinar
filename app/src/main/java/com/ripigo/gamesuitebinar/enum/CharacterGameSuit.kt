package com.ripigo.gamesuitebinar.enum

enum class CharacterGameSuit(val value: Int) {
    IDDLE(-1),
    ROCK(0),
    PAPER(1),
    SCISSOR(2);
    companion object {

        fun formInt(value: Int) = values().first { it.value == value }
    }
}