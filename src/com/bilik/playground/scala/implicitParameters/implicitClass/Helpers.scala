package com.bilik.playground.scala.implicitParameters.implicitClass

import com.bilik.playground.scala.implicitParameters.implicitClass.Helpers.IntWithTimes

/**
 * Implicit classes have the following restrictions:
 * 1. They must be defined inside another trait/class/object.
 * 2. They may only take one non-implicit argument in their constructor.
 * 3. The implicit def introduced by implicit class must not be ambiguous with respect to other term members.
 *     Note: This means an implicit class cannot be a case class, since the implicit def would be ambiguous with the companion apply.
 */
object Helpers {
  implicit class IntWithTimes(x: Int) {
    def times[A](f: => A): Unit = {
      def loop(current: Int): Unit =
        if(current > 0) {
          f
          loop(current - 1)
        }
      loop(x)
    }
  }
}

object TestHelpers {
  def main(args: Array[String]): Unit = {

    5 times println("HI") // how we got this ?
    // 1
    Helpers.IntWithTimes(0).times(() => println("HI2"))
    // 2
    Helpers.IntWithTimes(0) times(() => println("HI2"))
    // 3
    Helpers.IntWithTimes(0) times(println("HI2"))
    // 4
    Helpers.IntWithTimes(0) times println("HI2")
    // 5
    IntWithTimes(0) times println("HI2")
    // 6
    0 times println("HI2")
  }
}