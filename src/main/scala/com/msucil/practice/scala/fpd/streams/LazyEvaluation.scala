package com.msucil.practice.scala.fpd.streams

object LazyEvaluation {
  def expr = {
    val x =  {print("x"); 1} // evaluated only once at the definition time
    lazy val y = {print("y"); 2} // evaluated only once when it is invoked and reuse evaluation
    def z = {print("z"); 3} // evaluated every time when it is invoked

    z + y + x + z + y + x
  }

  def main(args: Array[String]): Unit = {
    expr
  }
}
