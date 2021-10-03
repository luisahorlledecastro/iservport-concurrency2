package com.iservport.concurrency
package domain

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers

class HandSpec extends AnyFreeSpec with Matchers {

  "A Hand" - {

    val cards = Seq.empty

    val hand = Hand(cards)

    "must return a new hand with an added card" in {

      val C_1_B = GameCard(CardSuit.C, CardFace._1, CardColour.B)
      hand.add(C_1_B) must be(Hand(Seq(C_1_B)))
    }
  }
}
