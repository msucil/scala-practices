package com.msucil.practice.scala.fp.currying

import scala.math.abs

/**
  * Fixed point of a function
  * f(x) = x
  */
object FixedPointF {

  val tolerance = 0.0001

  def isCloseEnough(x: Double, y: Double): Boolean =
    abs((x - y) / x) / x < tolerance

  def fixedPoint(f: Double => Double)(firstGuess: Double): Double = {
    def iterate(guess: Double): Double = {
      val next = f(guess);
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }

    iterate(firstGuess)
  }

  def sqrt(x: Double): Double = fixedPoint(y => (y+ x/y)/2)(1)

  def averageDamp(f: Double => Double)(x: Double): Double = (x + f(x)) / 2

  def sqrt2(x: Double): Double = fixedPoint(averageDamp(y => x / y))(1)

  def main(args: Array[String]): Unit = {
    println(fixedPoint(x => 1 + x / 2)(1))

    println(sqrt(4))
    println(sqrt2(4))
  }
}
