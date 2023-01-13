package com.bilik.playground.scala

import scala.collection.mutable.{ArrayBuffer, ArrayStack}
import scala.io.StdIn

object ArrayTest {

  def main(args : Array[String]): Unit = {

    val myArray = Array(1, 2, 3, 4)

    println("hey there: " + myArray.mkString(", "))

    // BUFFER
    val friends = ArrayBuffer[String]()
    friends.insert(0, "Phil")
    friends += "Emil"
    friends ++= Array("Uno", "dos")
    friends.insert(1, "oOmeone")

    println(friends)

    val myArray2 = for (i <- 1 to 10 if (i % 2 == 0)) yield i * 2
    println("myArray2: " + myArray2)
    myArray2.foreach(println)

    for (i <- 1 to 5; j <- 8 to 10) println(i + " - " + j)
    // or
    for (i <- 1 to 5) {
      for (j <- 8 to 10) {
        println(i + " - " + j)
      }
    }

    println("Sum: " + myArray2.sum)
    println("Min: " + myArray2.min)
    println("MAx: " + myArray2.max)

    //sort
    val forSort = Array(1, 54, 2, 66, 14, 32, 0)
    println("before: " + forSort.mkString(", "))
    val sorted = forSort.sortWith(_<_)
    println("after: " + sorted.sortWith(_>_).mkString(", "))

  }

}
