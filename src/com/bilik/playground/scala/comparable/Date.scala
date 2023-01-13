package com.bilik.playground.scala.comparable

class Date(y: Int, m: Int, d: Int) extends Ord {
  // these are getter methods, now variables. Variables are defined in braces above
  def year = y
  def month = m
  def day = d
  override def toString(): String = s"$year-$month-$day"

  // rest of implementation will go here

  override def equals(that: Any): Boolean = that match {
    case d: Date => d.day == day && d.month == month && d.year == year
    case _ => false
  }

  override def <(that: Any): Boolean = that match {
    case d: Date =>
      (year < d.year) ||
        (year == d.year && (month < d.month || (month == d.month && day < d.day)))

    case _ => sys.error("cannot compare " + that + " and a Date")
  }
}

object DateTest {
  def main(args: Array[String]): Unit = {
    val date1: Date = new Date(2022, 1, 9)
    val date2: Date = new Date(2022, 1, 8)
    println(date1 < date2)
    println(date1 <= date2)
    println(date1 == date2)
    println(date1 != date2)
    println(date1 > date2)
    println(date1 >= date2)

  }

}
