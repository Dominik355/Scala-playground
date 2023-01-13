package com.bilik.playground.scala

/**
 * The class contains two methods, called re and im, which give access to these two parts.
 *
 * It should be noted that the return type of these two methods is not given explicitly.
 * It will be inferred automatically by the compiler, which looks at the right-hand side
 * of these methods and deduces that both return a value of type Double.
 *
 * The inferred result type of a method can change in subtle ways if the implementation changes,
 * which could have a knock-on effect. Hence it is a best practise to put explicit result types
 * for public members of classes.
 */
class ComplexNumber(real: Double, imaginary: Double) {
  def re() : Double = real
  def im() = imaginary

  override def toString: String = re().toString + im().toString
}
