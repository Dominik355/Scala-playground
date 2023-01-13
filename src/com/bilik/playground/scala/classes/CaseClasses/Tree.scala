package com.bilik.playground.scala.classes.CaseClasses

/**
 * Scala 2 provides the concept of case classes which is somewhat in between the two.
 * Here is how they can be used to define the type of the trees for our example:
 *
 * 'SUM' is the addition of the evaluations of its two inner expressions;
 * the value of a 'VAR' is obtained by lookup of its inner name in the environment;
 * the value of a 'CONST' is its inner value itself;
 */
abstract class Tree

object TreeObject {

  case class Sum(l: Tree, r: Tree) extends Tree
  case class Var(n: String) extends Tree
  case class Const(v: Int) extends Tree

  type Environment = String => Int
  val ev: Environment = {
    case "x" => 5
  }

  def eval(t: Tree, ev: Environment): Int = t match {
    case Sum(l, r) => eval(l, ev) + eval(r, ev)
    case Var(n) => ev(n)
    case Const(v) => v
  }

  def evalWithoutAlias(t: Tree, ev: String => Int): Int = t match {
    case Sum(l, r) => eval(l, ev) + eval(r, ev)
    case Var(n) => ev(n)
    case Const(v) => v
  }

  /**
   * Adding new operation - DERIVATION
   * Just reminder:
   * 1. the derivative of a sum is the sum of the derivatives,
   * 2. the derivative of some variable v is one if v is the variable relative to which the derivation takes place, and zero otherwise,
   * 3. the derivative of a constant is zero.
   */
  def derive(t: Tree, v: String): Tree = t match {
    case Sum(l, r) => Sum(derive(l, v), derive(r, v))
    case Var(n) if v == n => Const(1)
    case _ => Const(0)
  }

  def main(args: Array[String]): Unit = {
    val exp: Tree = Sum(Sum(Var("x"), Var("x")), Sum(Const(7), Var("y")))
    val env: Environment = {
      case "x" => 5
      case "y" => 7
    }
    println("Expression: " + exp)
    println("Evaluation with x=5, y=7: " + eval(exp, env))
    println("Derivative relative to x:\n " + derive(exp, "x"))
    println("Derivative relative to y:\n " + derive(exp, "y"))
  }
}


