/* 
 * @project project-euler
 * @author raul.reguillo on 2020-11-18
 */

object Problem026 extends App{
  val LIMIT = 1000
  def checkDivision(numerator :Int, denominator :Int, remainList :List[Int]) :Int = {
    val remain = numerator % denominator
    if (remain == 0)
      0
    else {
      val index = remainList.indexOf(remain)

      if (index >= 0)
        index + 1
      else
        checkDivision(numerator = remain * 10, denominator, remain :: remainList)
    }
  }
  var results = (1 until LIMIT).map(checkDivision(numerator = 1, _, Nil))
  println(
    results.indexOf(results.max)+1
  )
}
