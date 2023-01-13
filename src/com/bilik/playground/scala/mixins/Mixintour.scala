package com.bilik.playground.scala.mixins

/**
 * Mixins are traits which are used to compose a class.
 */
class Mixintour {
  def main(args: Array[String]): Unit = {

    val d = new D
    println(d.message) // I'm an instance of class B
    println(d.loudMessage) // I'M AN INSTANCE OF CLASS B

  } //END OF MAIN

  abstract class A {
    val message: String
  }

  class B extends A {
    override val message = "I'm an instance of class B"
  }

  trait C extends A {
    def loudMessage = message.toUpperCase()
  }

  class D extends B with C

}
