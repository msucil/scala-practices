package com.msucil.practice.scala.fp.recursion

/**
  * Higher Order Function Example
  *
  */
object HOF {

  /**
    * Return sum of f(x) from x to y
    * Uses Linear Recursion which in turn may arias exception with large number differences
    *
    * @param f function
    * @param x from value
    * @param y to value
    * @return Int
    */
  def sum(f: Int => Int, x: Int, y: Int): Int = {
    if (x > y) 0
    else f(x) + sum(f, x + 1, y) // expression is evaluated at the end
  }

  def main(args: Array[String]): Unit = {
    // print sum of squire from 2 to 5
    println(sum(x => x * x, 2, 5))

    // print sum of cube from 2 to 4
    println(sum(x => x * x * x, 2, 4))
  }
}
