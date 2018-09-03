package com.msucil.practice.scala.fp.list

class MergeSort {

  def sort(xs: List[Int]): List[Int] = {
    val n = xs.length/2
    if(n == 0) xs
    else {
      val (fst, snd) = xs splitAt n
      merge(sort(fst), sort(snd))
    }
  }

  def merge(xs: List[Int], ys: List[Int]): List[Int] = {
    (xs, ys) match {
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      case (x :: xs1, y :: ys1) =>
        if (x < y) x :: merge(xs1, ys)
        else y :: merge(xs, ys1)
    }
  }

  def merge0(xs: List[Int], ys: List[Int]): List[Int] = {
    xs match {
      case Nil => ys
      case x :: xs1 => {
        ys match {
          case Nil => xs
          case y :: ys1 => {
            if(x < y) x :: merge(xs1, ys)
            else y :: merge(xs, ys1)
          }
        }
      }
    }
  }
}
