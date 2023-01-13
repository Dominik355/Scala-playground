package com.bilik.playground.scala

object Test {
  def main(args: Array[String]): Unit = {
    def foo(n: Int, v: Int) =
      for (i <- 0 until n;
           j <- 0 until n if i + j == v)
      yield (i, j)

    // shortened
    foo(10, 10).foreach {
      case (i, j) =>
        println(s"($i, $j) ") // prints (1, 9) (2, 8) (3, 7) (4, 6) (5, 5) (6, 4) (7, 3) (8, 2) (9, 1)
    }

    // another shortened but without case
    foo(10, 10).foreach(tuple => println(s"(${tuple._1}, ${tuple._2}) "))

    foo(10, 10).foreach(tuple => {
      tuple match {
        case (i, j) => println(s"($i, $j) ")
        case tuple: Tuple2[Int, Int] => println(tuple) // wont get here case first case is right
      }
    })
  }

}
