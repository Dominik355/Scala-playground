package com.bilik.playground.scala.tuples

object TupleTest {
  def main(args: Array[String]): Unit = {
    val tuplethree = (103, "Emil", 10.98)
    printf("%s owes us $%.2f\n", tuplethree._2, tuplethree._3)

    tuplethree.productIterator.foreach(i => println(i))
    tuplethree.productIterator.foreach(println)
    println(tuplethree.toString())

    val anotherTupleThree = (1231, "something", 43.321)
    println(anotherTupleThree.toString())

    // and this is how yo ucan define Tuple2
    val tupleTwo = "first" -> 32131
    println(tupleTwo.toString())
  }
}
