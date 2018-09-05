package com.msucil.practice.scala.fp.collection

/**
  * Given a positive integer N, find all pairs of positive integer i and j
  * with 1 <= j < i < n such that i + j is prime
  */
object PairOfPrime {

  def isPrime(n: Int): Boolean = (2 until n) forall (n % _ != 0)

  def pairOfPrime1(n: Int): Unit = {
    val primePairs = (1 until n) flatMap (i =>
      1 until i map (j => (i, j))) filter (pair => isPrime(pair._1 + pair._2))
    println(primePairs)
  }

  def pairOfPrime2(n: Int) = {
    val primePairs =
      for {
        i <- 1 until n
        j <- 1 until i
        if isPrime(i + j)
      }
        yield (i, j)

    println(primePairs)
  }

  def main(args: Array[String]): Unit = {
    pairOfPrime1(7)
    pairOfPrime2(7)
  }

}
