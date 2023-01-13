package com.bilik.playground.scala

class ComplexNumberAsFields(real: Double, imaginary: Double) {
  def re = real
  def im = imaginary

  override def toString: String =
    "" + re + (if (im >= 0) "+" else "") + im + "i"
}
