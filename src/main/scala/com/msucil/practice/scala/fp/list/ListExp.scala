package com.msucil.practice.scala.fp.list

class ListExp {

  // return last element of the list
  def last[T](xs: List[T]): T = xs match {
    case List() => throw new Error("Last of empty list")
    case List(x) => x
    case y :: ys => last(ys)
  }

  // return all the element of the list except last element
  def init[T](xs: List[T]): List[T] = xs match {
    case List() => throw new Error("Init of empty list")
    case List(x) => List()
    case y :: ys => y :: init(ys)
  }

}
