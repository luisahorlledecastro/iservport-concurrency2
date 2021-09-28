package com.iservport.concurrency

import domain.CardDeck

object Application extends App {

  val deck = CardDeck()

  println("Started with: "+deck.all.mkString("\n"))

  println("Shuffled: "+deck.shuffle().mkString("\n"))
}
