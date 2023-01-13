package com.bilik.playground.scala.mixins

object MixInIterator {
  def main(args: Array[String]): Unit = {

    val richStringIter = new RichStringIter
    richStringIter.foreach(println)

  } // END OF MAIN
}

// in this case, withotu additional functionality in abstract class, we can calmly replace this for trait and it all still works
// also change 'type T' for generics
abstract class AbsIterator {
  type T
  def hasNext: Boolean
  def next(): T
}

// implementation
//StringIterator takes a String and can be used to iterate over the String (e.g. to see if a String contains a certain character).
class StringIterator(s: String) extends AbsIterator {
  type T = Char
  private var i = 0
  def hasNext = i < s.length
  def next() = {
    val ch = s.charAt(i)
    i += 1
    ch
  }
}

// Now let’s create a trait which also extends AbsIterator.
trait RichIterator extends AbsIterator {
  def foreach(f: T => Unit): Unit = while (hasNext) f(next())
}

// We would like to combine the functionality of StringIterator and RichIterator into a single class.
class RichStringIter extends StringIterator("Scala") with RichIterator

// so what is the difference ? -> https://stackoverflow.com/questions/36732357/what-is-the-difference-between-mixins-and-inheritance
