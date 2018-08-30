package com.msucil.practice.scala.fp.hof

/**
  * Tail Recursion implementation
  */
object HOFTail {

  def sum(f: Int => Int, x: Int, y: Int): Int = {
    def loop(acc: Int, x: Int): Int = {
      if(x > y) acc
      else loop(acc + f(x), x + 1) // expression is evaluated instantly
    }

    loop(0, x)
  }

  def main(args: Array[String]): Unit = {
    println(sum(x => x * x, 2, 5))

    println(sum(x => x * x * x, 2, 4))
  }

}
