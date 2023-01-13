package com.bilik.playground.scala

import java.time.LocalDate
import java.time.format.{DateTimeFormatter, FormatStyle}
import java.util.Locale._

object HelloWorld {
  def main(args: Array[String]): Unit = {
    val now = LocalDate.now()
    val df = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(ENGLISH)
    println(df.format(now))
  }
}