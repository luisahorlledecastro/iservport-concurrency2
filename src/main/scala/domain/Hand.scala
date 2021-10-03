package com.iservport.concurrency
package domain

case class Hand(cards: Seq[GameCard]) {

  def add(card: GameCard): Hand =
    copy(cards = cards.appended(card))
}
