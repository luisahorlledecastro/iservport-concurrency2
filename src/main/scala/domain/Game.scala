package com.iservport.concurrency
package domain

import scala.collection.mutable
import scala.util.Random

case class Game(playerRed: Player, playerBlack: Player, heap: mutable.Buffer[GameCard],
                table: mutable.Buffer[GameCard], round: CardColour) {

  def play(index: Int): Game = {
    currentPlayer.pick(index, table) match {
      case Some(card) => // player is successful
        // as table and heap are mutable, they are updated in place
        heap.headOption.foreach { cardFromHeap => // if there is a card on the top of the heap
          table.update(index, cardFromHeap) // the new card replaces the one taken by the player
          heap.dropInPlace(0) // remove the top of the heap
        }
        updateGame(card)
      case None => switchPlayer
    }
  }

  private val currentPlayer: Player =
    round match {
      case CardColour.B => playerBlack
      case CardColour.R => playerRed
    }

  private def updateGame(card: GameCard): Game =
    card.colour match {
      case CardColour.B => copy(playerBlack = currentPlayer.add(card))
      case CardColour.R => copy(playerRed = currentPlayer.add(card))
    }

  private def switchPlayer: Game =
    round match {
      case CardColour.B => copy(round = CardColour.R)
      case CardColour.R => copy(round = CardColour.B)
    }

  val isOver: Boolean =
    currentPlayer.hand.cards.map(_.face).filterNot(_.isNumeric).map(_.name()).mkString == Game.fullHand
  // Scala note: a single argument function like y = f(x), also noted as x => y, can be written as _.f
  // Example: card => card.face is a function taking a card and returning a face, or GameCard => CardFace, can be _.face
}
object Game {

  def newGame: Game = {

    val startWith: CardColour = CardColour.values()(Random.nextInt() % 2) // Either 0 or 1, mapping to Black or Red
    val (heap: Seq[GameCard], table: Seq[GameCard]) =
      CardDeck().cards.partition(_.face.isNumeric)

    Game(Player.playerRed, Player.playerBlack, heap.toBuffer, table.toBuffer, startWith)
  }

  val fullHand: String = CardFace.values().filterNot(_.isNumeric).map(_.name()).mkString
}

