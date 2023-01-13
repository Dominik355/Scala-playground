package com.bilik.playground.scala.classes

object ClassesTour {
  def main(args: Array[String]): Unit = {

    val point1_1 = new Point
    point1_1.x = 99
    point1_1.y = 101
    val point1_2 = new Point(32, 53)

    val point2_1 = new Point2
    point2_1.x = 9900
    point2_1.y = 10100

    println(point1_1)
    println(point1_2)
    println(point2_1)
  }
}

/**
 * Here are 2 exactly the same classes ... what is the difference ?
 * Point - variables defined in brackets also create the default constructor for us. If we want
 * to have empty constructor, we have to explicitly define it using 'this'
 *
 * Point2 - default constructor is empty, variables defined inside the class
 */

class Point(private var _x: Int = 0, private var _y: Int = 0, private var bound: Int = 100) {
  def this() {
    this(0, 0, 1000000)
  }

  def x: Int = _x

  def x_=(newValue: Int): Unit = {
    if (newValue < bound)
      _x = newValue
    else
      printWarning()
  }

  def y: Int = _y

  def y_=(newValue: Int): Unit = {
    if (newValue < bound)
      _y = newValue
    else
      printWarning()
  }

  private def printWarning(): Unit =
    println("WARNING: Out of bounds")

  override def toString: String = "%s, %s, %s".format(x, y, bound)
}

class Point2 {
  private var _x = 0
  private var _y = 0
  private val bound = 100

  def x: Int = _x
  def x_=(newValue: Int): Unit = {
    if (newValue < bound)
      _x = newValue
    else
      printWarning()
  }

  def y: Int = _y
  def y_=(newValue: Int): Unit = {
    if (newValue < bound)
      _y = newValue
    else
      printWarning()
  }

  private def printWarning(): Unit =
    println("WARNING: Out of bounds")

  override def toString: String = "%s, %s, %s".format(x, y, bound)
}
