package com.msucil.practice.scala.fp.recursion


/**
  * Normal/Linear recursion implementation of factorial
  */
object Factorial {

  def factorialOf(n: Int): Int = {
    if(n == 0) 1
    else n * factorialOf(n -1)
  }

  def main(args: Array[String]): Unit = {
    println(factorialOf(4))
  }
}
