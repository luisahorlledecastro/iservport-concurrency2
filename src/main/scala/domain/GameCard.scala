package com.iservport.concurrency
package domain

import scala.language.postfixOps

case class GameCard(suit: CardSuit, face: CardFace, colour: CardColour) extends Ordered[GameCard] {

  val id: String = s"${suit}_${face}_${colour}"

  override def toString: String = id

  override def compare(that: GameCard): Int = this.id compare that.id
}
