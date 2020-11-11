/* 
 * @project project-euler
 * @author raul.reguillo on 2020-11-11
 */

object Problem021 extends App{
  val LIMIT = 10000

  def divisors (n :Int) :List[Int] = List.range(1, n/2 +1).filter(d => n % d == 0)

  val amNumbers =
    List.range(1, LIMIT).filter(n => {
      val sumDivisors = divisors(n).sum
      n == divisors(sumDivisors).sum && n != sumDivisors && sumDivisors < LIMIT
    })

  // println(amNumbers)
  println(
    amNumbers.sum
  )
}
