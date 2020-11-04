/* 
 * @project project-euler
 * @author raul.reguillo on 2020-11-04
 */

object Problem017 extends App{
  val units = Array("", "one", "two", "three", "four",
    "five", "six", "seven", "eight", "nine")

  val tens = Array("ten", "twenty", "thirty", "forty",
    "fifty", "sixty", "seventy", "eighty", "ninety")

  val teens = Array("ten", "eleven", "twelve", "thirteen", "fourteen",
    "fifteen", "sixteen", "seventeen", "eighteen", "nineteen")

  def toWords(number :Int) :String = {
    if (number >= 1000) {
      "onethousand"
    }
    else if (number >= 100) {
      if (number % 100 == 0)
        toWords(number/100) + "hundred"
      else
        toWords(number/100) + "hundredand" + toWords(number % 100)
    }
    else if (number >= 20) {
      if (number % 10 == 0)
        tens(number/10 - 1)
      else
        tens(number/10 - 1) + toWords(number % 10)
    }
    else if (number >= 10)
      teens(number-10)
    else
      units(number)
  }

  println(
    (1 to 1000).map(toWords(_).length).sum
  )
}
