package com.bilik.playground.scala.implicitParameters

import com.bilik.playground.scala.implicitParameters.Comparator._

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