package com.bilik.playground.scala.operators

object OperatorsTour {
  def main(args: Array[String]): Unit = {

    println(10 + 1) // same as
    println(10.+(1))

    // Vec
    val vector1 = Vec(1.0, 1.0)
    val vector2 = Vec(2.0, 2.0)

    val vector3 = vector1 + vector2
    println(vector3.x) // 3.0
    println(vector3.y) // 3.0

  } // END OF MAIN
}

case class Vec(x: Double, y: Double) {
  def +(that: Vec) = Vec(this.x + that.x, this.y + that.y)
}