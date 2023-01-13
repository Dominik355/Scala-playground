package com.bilik.playground.scala

object ComplexMain {
  def main(args: Array[String]): Unit = {
    val cn = new ComplexNumber(1.5, 2.4)
    println(cn.im())

    val cnf = new ComplexNumberAsFields(1.5, 2.4)
    println(cnf)
  }
}
