package com.msucil.practice.scala.fp.list

/**
  * List fundamental function implementation
  */
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

  //Concatenation of List
  // xs ::: ys ==> ys . ::: (xs)
  def concat[T](xs: List[T], ys: List[T]): List[T] = {
    xs match {
      case List() => ys
      case z :: zs => z :: concat(zs, ys) // complexity length of xs
    }
  }

  def reverse[T](xs: List[T]): List[T] = xs match {
    case List() => List()
    case y :: ys => reverse(ys) ++ List(y) // complexity m * m where m is size
  }

  def removeAt[T](i: Int, xs: List[T]): List[T] = (xs take i) ::: (xs drop i + 1)
}
