package com.msucil.practice.scala.fpd.streams

object PrimeNumbers {
  // generate streams of numbers from n
  def from(n: Int): Stream[Int] = n #:: from(n + 1)

  /**
    * Sieve of Eratosthenes, ancient technique to calculate prime
    * Start with all integers from 2 which is the prime
    * Eliminate all multiple of 2
    * The first element of resulting list is 3, which is prime
    * Eliminate all multiple of 3
    * Iterate forever, At each Step, the first number is prime and we eliminate all multiple of it
   */
  def sieveCalculatePrime(s: Stream[Int]): Stream[Int] = {
    s.head #:: sieveCalculatePrime(s.tail filter(_ % s.head == 0))
  }

  def main(args: Array[String]): Unit = {
    val primes = sieveCalculatePrime(from(2))
    println(primes.take(20).toList)
  }
}
