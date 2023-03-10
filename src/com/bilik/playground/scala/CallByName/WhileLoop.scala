package com.bilik.playground.scala.CallByName

object WhileLoop {

  def main(args: Array[String]): Unit = {
    var i = 2

    whileLoop(i > 0) {
      println(i)
      i -= 1
    }
  }

  def whileLoop(condition: => Boolean)(body: => Unit): Unit =
    if (condition) {
      body
      whileLoop(condition)(body)
    }

}
