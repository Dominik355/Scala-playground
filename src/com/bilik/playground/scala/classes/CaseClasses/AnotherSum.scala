package com.bilik.playground.scala.classes.CaseClasses

/**
 * Yes, we cas define case class separately in own file.
 * This way we do not have to call 'Tree.CaseClass', but only 'CaseClass'
 */
case class AnotherSum(first: String, second: String) extends Tree {

}
