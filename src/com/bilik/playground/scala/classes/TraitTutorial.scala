package com.bilik.playground.scala.classes

object TraitTutorial {
  def main(args: Array[String]): Unit = {

    val superman = new SuperHero("Superman")
    println(superman.fly)
    println(superman.hitByBullet)
    println(superman.ricochet(43.55))

  } //  END OF MAIN

  trait Flyable {
    def fly: String
  }

  trait BulletProof {
    def hitByBullet: String

    // traits unlike interfaces can have implementation functions
    def ricochet(startSpeed: Double): String = {
      "the bullet ricochets at a speed of %.1f ft/sec".format(startSpeed * .75)
    }
  }

  class SuperHero(name: String) extends Flyable with BulletProof {
    override def fly: String = name + "flys throught the air"

    override def hitByBullet: String = "%s can never by hit by bullet .. i guess".format(name)
  }

}
