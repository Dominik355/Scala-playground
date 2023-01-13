package com.bilik.playground.scala.genericity.abstractTypeMembers

trait Buffer {
  type T
  val element: T
}

/**
 * This class SeqBuffer allows us to store only sequences in the buffer by stating that type T
 * has to be a subtype of Seq[U] for a new abstract type U.
 */
abstract class SeqBuffer extends Buffer {
  type U
  type T <: Seq[U]
  def length = element.length
}

abstract class IntSeqBuffer extends SeqBuffer {
  type U = Int
}

object BufferTest {
  def main(args: Array[String]): Unit = {

    def newIntSeqBuf(elem1: Int, elem2: Int): IntSeqBuffer =
      new IntSeqBuffer {
        type T = List[U]
        val element = List(elem1, elem2)
      }

    val buf = newIntSeqBuf(7, 8)
    println("length = " + buf.length)
    println("content = " + buf.element)

  }
}