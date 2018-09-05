package com.msucil.practice.scala.fp.list

import scala.math.Ordering

object ParameterizeMergeSort {
  def sort[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = {
        (xs, ys) match {
          case (Nil, ys) => ys
          case (xs, Nil) => xs
          case (x :: xs1, y :: ys1) =>
            if (lt(x, y)) x :: merge(xs1, ys)
            else y :: merge(xs, ys1)
        }
      }

      val (fst, snd) = xs splitAt n
      merge(sort(fst)(lt), sort(snd)(lt))
    }
  }

  def sort1[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = {
        (xs, ys) match {
          case (Nil, ys) => ys
          case (xs, Nil) => xs
          case (x :: xs1, y :: ys1) =>
            if (ord.lt(x, y)) x :: merge(xs1, ys)
            else y :: merge(xs, ys1)
        }
      }

      val (fst, snd) = xs splitAt n
      merge(sort1(fst), sort1(snd))
    }
  }

  def main(args: Array[String]): Unit = {
    val nums = List(2, 5, 23, 11, -2, 10)
    println(sort(nums)((x: Int, y: Int) => x < y))

    val books = List("Java", "C#", "C", "Angular")
    println(sort(books)((x: String, y: String) => x.compareTo(y) < 0))

    println(sort1(nums))
  }
}
