package com.bilik.playground.scala.implicitParameters

object ImplicitTour {
  def main(args: Array[String]): Unit = {

    def max[A](x: A, y: A)(implicit comparator: Comparator[A]): A =
      if (comparator.compare(x, y) >= 0) x
      else y

    println(max(10, 6)) // 10
    println(max("hello", "world")) // world

    // if we didnt use "implicit", we would have t odefine types of method like :
//    println(max[Int](10, 6))
//    println(max[String]("hello", "world"))

  } // END OF MAIN
}

trait Comparator[A] {
  def compare(x: A, y: A): Int
}

object Comparator {
  implicit object IntComparator extends Comparator[Int] {
    def compare(x: Int, y: Int): Int = Integer.compare(x, y)
  }

  implicit object StringComparator extends Comparator[String] {
    def compare(x: String, y: String): Int = x.compareTo(y)
  }
}