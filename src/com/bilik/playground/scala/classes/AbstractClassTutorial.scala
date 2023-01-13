package com.bilik.playground.scala.classes

object AbstractClassTutorial {
  def main(args: Array[String]): Unit = {
    val fang: Wolf = new Wolf("Fang")
    println(fang.moveSpeed)
    println(fang.move)
  }

  abstract class Mammal(val name: String) {
    var moveSpeed: Double

    def move: String
  }

  class Wolf(name: String) extends Mammal(name) {
    override var moveSpeed: Double = 33.54

    override def move: String = "Wolf " + name + " is moving with speed: " + moveSpeed
  }
}
