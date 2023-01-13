package com.bilik.playground.scala

object Numbers {
  def main(args: Array[String]): Unit = {
    val x = 3
    var r = 1 + 2 * 3 / x
    //r = 1.+(2.*(3)./(x))
    r = 1.+(2.*(3)./(x))
    System.out.println(r)
    println(r) // this is just predefined scala method of System.out.println()
  }

}
