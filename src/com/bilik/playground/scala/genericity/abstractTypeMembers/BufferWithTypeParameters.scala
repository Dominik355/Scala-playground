package com.bilik.playground.scala.genericity.abstractTypeMembers

/**
 * +T is used to hide concrete implementation of "Seq"
 * without "+" we would have to use only Seq and not it's implementations
 */
abstract class Buffer2[+T] {
  val element: T
}
abstract class SeqBuffer2[U, +T <: Seq[U]] extends Buffer2[T] {
  def length = element.length
}

object BufferWithTypeParameters {
  def main(args: Array[String]): Unit = {

    def newIntSeqBuf(e1: Int, e2: Int): SeqBuffer2[Int, Seq[Int]] =
      new SeqBuffer2[Int, List[Int]] {
        val element = List(e1, e2)
      }

    val buf = newIntSeqBuf(7, 8)
    println("length = " + buf.length)
    println("content = " + buf.element)

  }
}