package com.msucil.practice.scala.fp.decomposition

class Sum(left: Expr, right: Expr) extends Expr {
  override def isNumber: Boolean = false

  override def isSum: Boolean = true

  override def numValue: Int = throw new Error("Sum.numValue")

  override def leftOp: Expr = left

  override def rightOp: Expr = right
}
