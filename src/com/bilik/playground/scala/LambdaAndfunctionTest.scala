package com.bilik.playground.scala

object LambdaAndfunctionTestTest {
  def main(args : Array[String]): Unit = {
    val addOneP = (x:Int) => x + 1
    val addone: Int => Int = x => x + 1

    val addOneF = new Function1[Int, Int]() {
      override def apply(v1: Int): Int = v1 + v1
    }

    val addOneMy = new MyVoidFunction[Int]() {
      override def apply(v1: Int): Unit = println("MyVoidFunction for : " + v1)
    }

    val here: Int => Unit = x => println("here: " + x)

    println(addOneP(4))
    println(addone(4))
    println(addOneF(4))

    println(addOneP)
    println(addone)
    println(addOneF)

    println("addOneP: " + addOneP(4))
    println("addOneMy: " + addOneMy(4))
    println("here: " + here(4))

    println(addOneMy)
    println(here)
  }
}


trait MyVoidFunction[T1] extends AnyRef { self =>

  def apply(v1: T1): Unit

  override def toString(): String = "<MyFunction>"
}