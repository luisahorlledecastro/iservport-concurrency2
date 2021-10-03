package com.iservport.concurrency.domain

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers

class GameSpec extends AnyFreeSpec with Matchers {

  "A Game" - {

    "when starting" - {

      val game = Game.newGame

      "must have a player holding black cards" in {

        game.playerBlack must be (Player.playerBlack)
      }

      "must have a player holding red cards" in {

        game.playerRed must be (Player.playerRed)
      }

      "must have a table with all non-numeric cards" in {

        game.table.filterNot(_.isNumeric).mkString("|") must be (game.table.mkString("|"))
      }

      "must have a heap with all numeric cards" in {

        game.heap.filter(_.isNumeric).mkString("|") must be (game.heap.mkString("|"))
      }

      "must hold a full hand criterion" in {

        Game.fullHand must be ("_A_J_Q_K")
      }
    }
  }
}
