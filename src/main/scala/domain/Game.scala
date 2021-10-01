package com.iservport.concurrency
package domain

import scala.collection.mutable

case class Game(playerRed: Player, playerBlack: Player) {

  val shuffled: Seq[GameCard] = CardDeck.shuffle()
  val (heap: mutable.ArrayBuffer[GameCard], table: mutable.ArrayBuffer[GameCard]) =
    shuffled.partition(_.face.isNumeric)

  def isGameOver(player: Player) = {

  }

}
object Game {

  def apply(): Game = {
    val playerRed: Player = Player(Hand(Seq()), CardColour.RED)
    val playerBlack: Player = Player(Hand(Seq()), CardColour.BLACK)
    Game(playerRed, playerBlack)
  }

  val fullHand = CardFace.values().filterNot(_.isNumeric).map(_.name()).mkString

  def pick(index: Int, player: Player, table: mutable.ArrayBuffer[GameCard]): Option[GameCard] =
    table.lift(index).filterNot(_.colour == player.colour)

  def isGameOver(player: Player): Boolean =
    player.hand.cards.map(_.face).filterNot(_.isNumeric).map(_.name()).mkString == Game.fullHand
}

