package com.msucil.practice.scala.fp.data

object TestIntSet {

  def main(args: Array[String]): Unit = {
    val t1 = new NonEmpty(4, new Empty, new Empty)
    val t2 = t1 include 5
    println(t1)
    print(t2)
  }
}
