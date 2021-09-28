package com.iservport.concurrency
package domain

import scala.util.Random

case class CardDeck () {

  val all: Array[GameCard] = {
    for {
      colours <- CardColour.values()
      faces <- CardFace.values()
      suits <- CardSuit.values()
    } yield {
      GameCard(suits, faces, colours)
    }
  }

  def shuffle(): Seq[GameCard] = Random.shuffle(all.toSeq)
}
