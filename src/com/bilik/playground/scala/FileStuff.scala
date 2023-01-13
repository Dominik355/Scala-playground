package com.bilik.playground.scala

import java.io.PrintWriter
import scala.io.Source

object FileStuff {

  def main(args: Array[String]) {
    val writer = new PrintWriter("test.txt")
    writer.write("Some line over here\n and here is another one")
    writer.close()

    // read
    val textfromFile = Source.fromFile("test.txt", "UTF-8")

    val lineIterator = textfromFile.getLines()

    for (line <- lineIterator)
      println(line)

    textfromFile.close()
  }

}
