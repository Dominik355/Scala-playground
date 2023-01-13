package com.bilik.playground.scala

object WaysToDefineFunction {
  def main(args: Array[String]): Unit = {

    // 1
    val addOne: Int => Int = x => x + 1

    // 2 - miesto Int => Int definujeme parameter na mieste a return type sa odvodi sam
    val addTwo = (x: Int) => x + 1

    // 3 - preklada sa to vlastne do trait-u, ako functional interface v jave, robi to az kompiler
    val addThree = new Function1[Int, Int]() {
      override def apply(v1: Int): Int = v1 + 1
    }

    // 4 - cize is vies definovat aj vlastny takyto trait
    val addFour = new MyAdder[Int]() {
      override def apply(v1: Int): Int = v1 + 1
    }

    println("addOne: " + addOne)
    println("addOne: " + addTwo)
    println("addOne: " + addThree)
    println("addOne: " + addFour)

    println("addOne: " + addOne(4))
    println("addOne: " + addTwo(4))
    println("addOne: " + addThree(4))
    println("addOne: " + addFour(4))

    // or another example
    // 1 - definovany typ premennej bar1, oc je ufnkcia, ktora zoberie String a vrati Int
    // dalej = a samotna definiciap omocou lamby
    // zoberie sa 's', ktore uz vieme, zeje String => telo funkcie
    val bar1: String => Int = s => s match { case "a" => 123 case _ => s.length() }

    // 2 - tu miesto definovania typu, rovno priradime lambu, ktora prezentuje funkciu
    // cize dame hned '=' a definujeme vstupny parameter a vystupny je jasne zo samotneho tela funkcie (mozeme expllicitne definovat return)
    val bar2 = (s:String) => s match { case "a" => 123 case _ => s.length() }

    // rozdiel medzi 1 a 2 je v tom, kde su definovane typy parametrov, v 1 to je na lavej strane pri premennej,
    // pri 2 to je na pravej, kde Return type je odvotedy z tela funkcie

    // keby chceme, tak vieme skombit 1 a 2, no bolo by to iba definovanie typov na 2 miestach, cize zbytocnost
    // nazov: typ = samotna lamba prezentujuca telo
    val barTogether: String => Int = (s:String) => s match { case "a" => 123 case _ => s.length() }

    // 1_3 - z 1-ky vieme odvodid este 1 kratky zapis, kde ponechame typ funkcie a za '=' vyhodime 's => s match '
    // pretoze vieme, ze jediny vstupny parameter je string a pokial v metode nebude nic ine ako match-case, tak match mozeme vyhodit
    //scala automaticky doplni match pre ten jediny argument, ktory mame

    val bar1_3: String => Int = { case "a" => 123 case s => s.length() }

    // 2_3 - z 2-ky vieme tiez odvodid
    // nazov premennejsa rovna '=' telo funkcie, a to telo je funkcia typu String => Int
    val bar = { case "a" => 123 case s => s.length() }: String => Int
  }
}

trait MyAdder[T1] extends AnyRef { self =>

  def apply(v1: T1): Int

  override def toString(): String = "<MyFunction>"
}
