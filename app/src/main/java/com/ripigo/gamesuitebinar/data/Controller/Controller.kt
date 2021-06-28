package com.ripigo.gamesuitebinar.data.Controller

class Controller(private val callback: Callback) {
    fun rules(player1: String, player2: String) {
        val status = when {
            player2 == "Scissors" && player1 == "Paper" ||
                    player2 == "Rock" && player1== "Scissors" ||
                    player2 == "Paper" && player1 == "Rock" -> "Player 2 Winner"
            player1 == "Scissors" && player2 == "Paper" ||
                    player1 == "Rock" && player2 == "Scissors" ||
                    player1 == "Paper" && player2 == "Rock" -> "Player 1 Winner"
            else -> "Draw"
        }
        callback.sendStatus(status)
    }
}
