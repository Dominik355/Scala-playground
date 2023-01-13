package com.bilik.playground.scala.extractorObject

import scala.util.Random

/**
 * An extractor object is an object with an unapply method. Whereas the apply method is like a
 * constructor which takes arguments and creates an object, the unapply takes an object and tries to give
 * back the arguments. This is most often used in pattern matching and partial functions.
 */
object ExtractorObjectTour {
  def main(args: Array[String]): Unit = {
    val customer1ID = CustomerID.apply("Sukyoung") // e.g. Sukyoung--23098234908
    println("customer1ID: " + customer1ID)

    customer1ID match {
      case CustomerID(name) => println(name) // prints Sukyoung
      case _ => println("Could not extract a CustomerID")
    }

    //val customer2ID = CustomerID("Nico") - thats the same
    val customer2ID = CustomerID.apply("Nico")
    val CustomerID(name) = customer2ID // this again calls unapply
    // and this is equal to :
    val name2 = CustomerID.unapply(customer2ID).get

    println(name2)
    println(name) // prints Nico

    // or like this :
    val CustomerID(name3) = "-asdfasdfasdf"
    println(name3)

  } //  END OF MAIN
}

object CustomerID {

  def apply(name: String) = s"$name--${Random.nextLong()}"

  def unapply(customerID: String): Option[String] = {
    println("Unapply called for : " + customerID)
    val stringArray: Array[String] = customerID.split("--")
    if (stringArray.tail.nonEmpty)
      Some(stringArray.head)
    else
      None
  }
}
