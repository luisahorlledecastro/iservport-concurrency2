package com.iservport.concurrency
package domain

case class Game() {
    val playerRed: Player = Player(Hand(Seq()), CardColour.RED)
    val playerBlack: Player = Player(Hand(Seq()), CardColour.BLACK)

    def isGameOver(player: Player) = {
        
    }
}
