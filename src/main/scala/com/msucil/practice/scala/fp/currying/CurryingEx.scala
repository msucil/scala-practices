package com.msucil.practice.scala.fp.currying

/**
  * Curring: Making function returning function
  */
object CurryingEx {

  /**
    * Accepts function f, which return function loop that accepts two Int parameters which eventually returns Int
    *
    * @param f function
    * @return
    */
  def sum(f: Int => Int): (Int, Int) => Int = {
    def loop(x: Int, y: Int): Int = {
      if (x > y) 0
      else f(x) + loop(x + 1, y)
    }

    loop
  }

  def main(args: Array[String]): Unit = {
    /**
      * sum(x => x * x) returns loop(x: Int, y: Int)
      * on which we pass parameter (2, 5)
      */
    println(sum(x => x * x)(2, 5))

    println(sum(x => x * x * x)(2, 4))
  }

}
