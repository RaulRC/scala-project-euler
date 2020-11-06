/* 
 * @project project-euler
 * @author raul.reguillo on 2020-11-06
 */

object Problem019 extends App{

  def nDays(days: Int): Int => Int = (_ :Int) => days

  val leapsFebruary = (year :Int) =>
    if ((year % 4 == 0) && (year % 100 != 0 || year % 400 == 0)) 29 else 28

  val monthDays = Array(nDays(31), leapsFebruary, nDays(31), // January, February, March
    nDays(30), nDays(31), nDays(30), // April, May, June
    nDays(31), nDays(31), nDays(30), // July, August, September
    nDays(31), nDays(30), nDays(31)) // October, November, December

  val yearsAndMonths =
    for (
      year <- 1900 to 2000;
      month <- 0 to 11
    ) yield (year, month)

  println(
    ((0, 0) /: yearsAndMonths) {
    case ((suns, days), (year, month)) =>
      (
        if (year > 1900 && days % 7 == 6) suns + 1
        else suns, days + monthDays(month)(year)
      )}._1)
}
