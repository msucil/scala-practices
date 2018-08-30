package com.msucil.practice.scala.fp.currying

/**
  * Exercise
  * 1. Write a product function that calculates
  * the product of the values of a function for the points on a given interval.
  *
  * 2. Write factorial in terms of product.
  *
  * 3.  Can you write a more general function, which generalizes both sum and product?
  */
object CurryingEx {
  /**
    * Ex 1
    */
  def product(f: Int => Int)(x: Int, y: Int): Int = {
    if (x > y) 1
    else f(x) * product(f)(x + 1, y)
  }

  /**
    * Ex 2
    */
  def factorial(n: Int): Int = product(x => x)(1, n)

  /**
    * Ex 3
    */
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, default: Int)(x: Int, y: Int): Int = {
    if (x > y) default
    else combine(f(x), mapReduce(f, combine, default)(x + 1, y))
  }

  def product2(f: Int => Int)(x: Int, y: Int): Int = mapReduce(f, (x, y) => x * y, 1)(x, y)

  def factorial2(n: Int): Int = product2(x => x)(1, n)

  def main(args: Array[String]): Unit = {
    println(product(x => x * x)(3, 4))

    println(factorial(3))
    println(factorial2(3))
  }
}
