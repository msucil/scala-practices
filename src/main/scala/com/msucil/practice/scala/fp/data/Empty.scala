package com.msucil.practice.scala.fp.data

class Empty extends IntSet {
  override def include(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
  override def contains(x: Int): Boolean = false

  override def toString: String = "."
}
