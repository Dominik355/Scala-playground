package com.bilik.playground.scala

object MapTest {
  def main(args: Array[String]): Unit = {

    // immutable
    val employees = Map("manager" -> "Bob", "emplyee" -> "Emil")

    // mutable
    val customers = collection.mutable.Map(100 -> "Martin", 432 -> "Robert")

    // obtain
    printf("Customer 1: %s\n", customers.get(100).getOrElse("There is no such a customer"))
    printf("Customer 1: %s\n", customers(100))

    // change
    customers(100) = "New Martin"
    for ((k,v) <- customers) printf("%d : %s\n", k, v)

  }
}
