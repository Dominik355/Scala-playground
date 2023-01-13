package com.bilik.playground.scala

import scala.math.log10


object FunctionTutorial {
  def main(args: Array[String]): Unit = {
    val log10func = log10 _ // underscore converts method to a function
    // ako sme sa k tomu dostali ?
    val log10func2: Double => Double = x => log10(x) // toto je zaklad
    val log10func3 = x => log10(x) // vyhodime typove parametre, kedze tie su jasne z tela funkcie a jej navratoveho typu
    // to si mozeme dovolit pokial mame na tej strane iba 1 riadok a je jasne, co funkcia berie a vracia. Pokial by sme tam dali
    // cely novy blok funkcie, ja pokial je na konci jasny return z logaritmu... nemusi byt jasny vstupny parameter

    // a kedze chceme povedat, ze len passneme cokolvek hodnotu do danej ufnkcie, mozeme to nahradit s '_'
    val log10func4 = log10 _

    // ako vidime, mozeme si parametre definovat ajdodatocne - ale iba pokial uz nieje lambda na pravej strane
    val log10func5 = log10 _: Double => Double



    println(log10func(1000))
    println(log10func2(1000))
    println(log10func3(1000))
    println(log10func4(1000))
    println(log10func5(1000))

    List(1000.0, 10_000.0)
      .map(log10func)
      .foreach(println)

    List(1,2,3,4,5)
      .map(x => x * 14)
      .foreach(println)

    List(1,2,3,4,5)
      .filter(x => x > 2)
      .foreach(println)

  } // END OF MAIN

}
