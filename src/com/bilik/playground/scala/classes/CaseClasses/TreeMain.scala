package com.bilik.playground.scala.classes.CaseClasses

object TreeObjectMain {
  def main(args: Array[String]): Unit = {
    val tr = TreeObject.Sum(TreeObject.Const(5), TreeObject.Var("x"))
    println(tr)

    val tr2 = TreeObject.Sum(AnotherSum("one", "two"), TreeObject.Var("2"))
    println(tr2)

    val intResult = TreeObject.eval(tr, TreeObject.ev)
    println("intResult = " + intResult)

    // or we can define our own environment
    val intResult2 = TreeObject.eval(TreeObject.Sum(TreeObject.Const(5), TreeObject.Var("123")), x => x.toInt)
    println("intResult2 = " + intResult2)

    // and we can do the same without alias, alias is just a syntactic sugar for primarily reusable purposes ? i guess
    val intResultNoAlias = TreeObject.evalWithoutAlias(tr, TreeObject.ev)
    println("intResultNoAlias = " + intResultNoAlias)

    // or we can define our own environment
    val intResult2NoAlias = TreeObject.evalWithoutAlias(TreeObject.Sum(TreeObject.Const(5), TreeObject.Var("123")), x => x.toInt)
    println("intResult2NoAlias = " + intResult2NoAlias)
  }
}
