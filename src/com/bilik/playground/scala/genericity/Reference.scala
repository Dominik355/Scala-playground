package com.bilik.playground.scala.genericity

/**
 * The simplest container class possible: a reference, which can either be empty or point to an object of some type.
 */
class Reference[T] {
  // '_' represents a default value. This default value is 0 for numeric types, false for the Boolean type, () for the Unit type and null for all object types.
  private var contents: T = _
  def set(value: T): Unit = { this.contents = value }
  def get: T = contents // all of them works
  //def get = contents
  //def get: T = return this.contents
}

/**
 * To use this Reference class, one needs to specify which type to use for the type parameter T, that is the
 * type of the element contained by the cell. For example, to create and use a cell holding an integer, one could
 * write the following:
 */
object IntegerReference {
  def main(args: Array[String]): Unit = {
    val cell = new Reference[Int]
    cell.set(13)
    println("Reference contains the half of " + (cell.get * 2))
  }
}