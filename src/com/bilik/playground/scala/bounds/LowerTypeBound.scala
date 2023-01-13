package com.bilik.playground.scala.bounds

object LowerTypeBound {
  def main(args: Array[String]): Unit = {
    val africanSwallows: List[AfricanSwallow] = Nil.prepend(AfricanSwallow())
    val swallowsFromAntarctica: List[Bird] = Nil
    val someBird: Bird = EuropeanSwallow()

    // assign swallows to birds
    val birds: List[Bird] = africanSwallows

    // add some bird to swallows, `B` is `Bird`
    val someBirds = africanSwallows.prepend(someBird)

    // add a swallow to birds
    val moreBirds = birds.prepend(EuropeanSwallow())

    // add disparate swallows together, `B` is `Bird` because that is the supertype common to both swallows
    val allBirds = africanSwallows.prepend(EuropeanSwallow())

    // but this is a mistake! adding a list of birds widens the type arg too much. -Xlint will warn!
    val error = moreBirds.prepend(swallowsFromAntarctica) // List[Object]
  } // END OF MAIN
}

trait List[+A] {
  def prepend[B >: A](elem: B): NonEmptyList[B] = NonEmptyList(elem, this)
}

case class NonEmptyList[+A](head: A, tail: List[A]) extends List[A]

object Nil extends List[Nothing]


trait Bird
case class AfricanSwallow() extends Bird
case class EuropeanSwallow() extends Bird