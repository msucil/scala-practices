package com.msucil.practice.scala.fp.data

abstract class IntSet {
  def include(x: Int): IntSet
  def contains(x: Int): Boolean
}