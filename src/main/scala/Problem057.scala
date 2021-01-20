/* 
 * @project project-euler
 * @author raul.reguillo on 1/20/21
 */

object Problem057 extends App {
  val LIMIT = 1000

  case class Fraction(numerator: BigInt, denominator: BigInt) {
    def add (n :BigInt) = Fraction(n * denominator + numerator, denominator)
    def invert = Fraction(denominator, numerator)
    def hasMoreDigitsNum: Boolean = numerator.toString.length > denominator.toString.length
  }

  def expand (count: Int): Fraction =
    if (count == 0)
      Fraction(1, 2)
    else
      expand(count-1).add(2).invert

  println(
    (0 to LIMIT).count(i => expand(i).add(1).hasMoreDigitsNum)
  )
}

