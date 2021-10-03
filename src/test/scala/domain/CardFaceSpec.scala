package com.iservport.concurrency
package domain

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers

class CardFaceSpec extends AnyFreeSpec with Matchers {

  "A CardFace" - {

    "either is numeric" in {

      CardFace._1.isNumeric must be(true)
      CardFace._2.isNumeric must be(true)
      CardFace._3.isNumeric must be(true)
      CardFace._4.isNumeric must be(true)
      CardFace._5.isNumeric must be(true)
      CardFace._6.isNumeric must be(true)
      CardFace._7.isNumeric must be(true)
      CardFace._8.isNumeric must be(true)
      CardFace._9.isNumeric must be(true)
      CardFace._10.isNumeric must be(true)
    }

    "or is non-numeric" in {

      CardFace._J.isNumeric must be(false)
      CardFace._Q.isNumeric must be(false)
      CardFace._K.isNumeric must be(false)
      CardFace._A.isNumeric must be(false)
    }

    "is filtered accordingly" in {

      CardFace.values().filter(_.isNumeric).mkString must be("_1_2_3_4_5_6_7_8_9_10")
      CardFace.values().filterNot(_.isNumeric).mkString must be("_A_J_Q_K")
    }

    "is partitioned accordingly" in {

      val (numeric, nonNumeric) = CardFace.values().partition(_.isNumeric)
      numeric.mkString must be("_1_2_3_4_5_6_7_8_9_10")
      nonNumeric.mkString must be("_A_J_Q_K")
    }
  }
}
