package com.bilik.playground.scala.variances

/**
 * class Foo[+A] // A covariant class
 * class Bar[-A] // A contravariant class
 * class Baz[A]  // An invariant class
 */
object VariancesTour {
  def main(args: Array[String]): Unit = {
    val myAnimal: Animal = Cat("Felix")

    // What about boxes? Is Box[Cat] a subtype of Box[Animal], like Cat is a subtype of Animal ?
    val myCatBox: Box[Cat] = new Box[Cat](Cat("Felix"))
    // val myAnimalBox: Box[Animal] = myCatBox // this doesn't compile
    // val myAnimal: Animal = myAnimalBox.content

    val catbox: ImmutableBox[Cat] = new ImmutableBox[Cat](Cat("Felix"))
    val animalBox: ImmutableBox[Animal] = catbox // now this compiles


    val cats: List[Cat] = List(Cat("Whiskers"), Cat("Tom"))
    val dogs: List[Dog] = List(Dog("Fido"), Dog("Rex"))
    // prints: Whiskers, Tom
    printAnimalNames(cats)
    // prints: Fido, Rex
    printAnimalNames(dogs)


  } // END OF MAIN

  def printAnimalNames(animals: List[Animal]): Unit =
    animals.foreach {
      animal => println(animal.name)
    }

}

class Box[A](var content: A)

abstract class Animal {
  def name: String
}

case class Cat(name: String) extends Animal
case class Dog(name: String) extends Animal

// We say that ImmutableBox is covariant in A, and this is indicated by the + before the A. More formally,
// that gives us the following relationship: given some class Cov[+T], then if A is a subtype of B, Cov[A] is a subtype of Cov[B].
class ImmutableBox[+A](val content: A)