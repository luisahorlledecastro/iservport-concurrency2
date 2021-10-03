package com.iservport.concurrency
package domain

import scala.:+
import scala.collection.mutable

case class Player(hand: Hand, colour: CardColour) {

  def pick(index: Int, cards: mutable.Buffer[GameCard]): Option[GameCard] =
    cards.lift(index).filter(_.colour == colour)

  def add(card: GameCard): Player = {
    copy(hand = hand.add(card))
  }
}

object Player {

  def apply(colour: CardColour): Player = Player(Hand(Seq()), colour)

  val playerRed: Player = Player(Hand(Seq()), CardColour.R)
  val playerBlack: Player = Player(Hand(Seq()), CardColour.B)
}
