package com.bilik.playground.scala.classes

object ClassTutorial {
  def main(args: Array[String]) {
    val rover = new Animal()
    rover.setName("Rover")
    rover.setSound("Woof")
    println(rover.getName())
    println(rover.sound)
    println(rover.id)

    val whiskers = new Animal("Whiskers", "Meow")
    println("whiskers: " + whiskers.toString)

    val rony = Animal("Rony", "waf") // we added our own apply() factory method
    println("rony: " + rony.toString())

    Animal.whatIsThis()

    val spike = new Dog("Spike", "Woof", "Grrrr")
    println(spike)
  } //  END OF MAIN

  class Animal(private var name: String, var sound: String) {
    this.setSound(sound) // this is still part of the default constructor
    // what is part of construcotr ? everything, not definedi nside function, comment this and put it somewhere else - still works
    // another constructors
    def this() = {
      this("No name here 2", "No sound here 2")
    }

    def this(name: String) = {
      this("No name here", "No sound here")
      this.setName(name)
    }

    val id = Animal.newIdNum // calling static method of Animal

    protected var protectedName = "Protected Name"

    def getName(): String = name
    def getSound() = sound

    def setName(name: String) = this.name = name
    def setSound(sound: String) {
      println("Setting sound to : " + sound)
      if (!name.matches(".*\\d+.*"))
        this.sound = sound
      else
        this.name = "No name"
    }

    override def toString: String = "%s makes a sound %s".format(this.name, this.sound)
  }

  // companion object, which holds 'static' clas variabls and functions
  // so without 'static' word, everything here is static
  object Animal {
    private var idNumber = 0
    private def newIdNum {
      idNumber += 1
    }

    def whatIsThis() =
      println("This is animal companion object")

    def apply(name: String, sound: String) = {
      new Animal(name, sound)
    }
  }

  class Dog(name: String, sound: String, growl: String) extends Animal(name, sound) {
    def this(name: String, sound: String) {
      this(name, "No sound", "No Growl")
      this.setSound(sound) // cla it over etter for additional check
    }

    def this() {
      this("No name", "No Sound", "No Growl")
    }

    override def toString: String = "%s makes a sound %s and growl".format(this.name, this.sound, this.growl)
  }

}
