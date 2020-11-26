/* 
 * @project project-euler
 * @author raul.reguillo on 2020-11-26
 */

object Problem032 extends App{
  def digits (n :Int) :IndexedSeq[Int] = n.toString.map(_.asDigit)

  def isPandigital (a :Int, b :Int, n :Int) :Boolean =
    (digits(a) ++ digits(n) ++ digits(b)).sortWith(_<_) == (1 to 9)

  def hasPandigitalFactors(n :Int) :Boolean = (2 until 100) exists(a => n % a == 0 && isPandigital(a, n/a, n))

  println(
    1000 until 10000 filter hasPandigitalFactors sum
  )
}
