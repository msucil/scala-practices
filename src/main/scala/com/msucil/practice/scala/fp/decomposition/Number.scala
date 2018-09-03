package com.msucil.practice.scala.fp.decomposition

class Number(n: Int) extends Expr {
  override def isNumber: Boolean = true

  override def isSum: Boolean = false

  override def numValue: Int = n

  override def leftOp: Expr = throw new Error("Number.leftOp")

  override def rightOp: Expr = throw new Error("Number.rightOp")
}
