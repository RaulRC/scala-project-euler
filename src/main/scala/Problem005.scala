/* 
 * @project project-euler
 * @author raul.reguillo on 2020-10-19
 */

object Problem005 extends App{

  val divisors = 1 to 20
  def checkDivision (value :Int) :Int = {
    if (divisors.exists((x) => (value % x != 0))) return checkDivision(20 + value)
    else return value
  }
  println(checkDivision(20))
}
