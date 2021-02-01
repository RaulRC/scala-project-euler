/* 
 * @project project-euler
 * @author raul.reguillo on 2/1/21
 */

object Problem065 extends App{
  case class Fraction(numerator: BigInt, denominator: BigInt) {
    def + (n: BigInt) = Fraction(n * denominator + numerator, denominator)
    def invert = Fraction(denominator, numerator)
  }

  def compute(count: Int, n: Int): Fraction = {
    val term = if (n == 1) 2 else if (n % 3 == 0) 2 * (n/3) else 1
    if (n == count) Fraction(term, 1)
    else compute(count, n+1).invert + term
  }
  println(
    compute(count = 100, 1).numerator.toString map(_-'0') sum
  )

}
