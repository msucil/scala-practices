package com.msucil.practice.scala.fp.recursion

/**
  * Tail recursion of factorial
  */
object FactorialTailRecursion {

  def factorialOf(n: Int): Int = {

    /**
      *
      * @param acc default value to return
      * @param n value on which f(n) is applied
      * @return Int
      */
    def factor(acc: Int, n: Int): Int = {
      if(n == 0) acc else factor(acc * n, n -1)
    }

    factor(1, n)
  }

  def main(args: Array[String]): Unit = {
    println(factorialOf(4))
  }
}
