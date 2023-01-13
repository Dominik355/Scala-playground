package com.bilik.playground.scala.variances

object ContravariantTour {
  def main(args: Array[String]): Unit = {

    val animalSerializer: Serializer[Animal] =
      (animal: Animal) => s"""{ "name": "${animal.name}" }"""

    val catSerializer: Serializer[Cat] = animalSerializer
    catSerializer.serialize(Cat("Felix"))

  } // END OF MAIN
}

/**
 * More formally, that gives us the reverse relationship:
 * given some class Contra[-T], then if A is a subtype of B, Contra[B] is a subtype of Contra[A].
 */
abstract class Serializer[-A] {
  def serialize(a: A): String
}

