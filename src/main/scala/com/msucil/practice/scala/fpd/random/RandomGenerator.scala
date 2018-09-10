package com.msucil.practice.scala.fpd.random

object RandomGenerator {
  def booleanGenerator: Generator[Boolean] = {
    val integers: Generator[Integer] = new Generator[Integer] {
      val rand = new java.util.Random

      override def generate: Integer = rand.nextInt()
    }

    val booleans = new Generator[Boolean] {
      override def generate: Boolean = integers.generate > 0
    }

    booleans
  }

  def main(args: Array[String]): Unit = {
    val booleans = booleanGenerator

    for(i <- 1 until 10) {
      println(booleans.generate)
    }
  }
}
