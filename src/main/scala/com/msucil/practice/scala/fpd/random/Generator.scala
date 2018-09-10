package com.msucil.practice.scala.fpd.random

trait Generator[+T] {
  self =>

  def generate: T

  def map[S] (f: T => S): Generator[S] = new Generator[S] {
    override def generate: S = f(self.generate)
  }

  def flatMap[S](f: T => Generator[S]): Generator[S] = new Generator[S] {
    override def generate: S = f(self.generate).generate
  }
}
