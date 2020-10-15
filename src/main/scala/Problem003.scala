import scala.annotation.tailrec

/*
 * @project project-euler
 * @author raul.reguillo on 2020-10-15
 */

object Problem003 extends App{
  def isPrimeTail(n: BigInt): Boolean = {
    @tailrec
    def isDivisibleBy(a: BigInt, b: BigInt): Boolean =
      if (b > 1) (a % b == 0) || isDivisibleBy(a, b-1) else false
    !isDivisibleBy(n, n/2)
  }
  def biggestPrimeFactor(n: BigInt, div: BigInt = 2, max: BigInt = 1): BigInt =
    if(div > n) max
    else
      if(n % div == 0)
        if (isPrimeTail(div)) biggestPrimeFactor(BigInt((n/div).toLong), div, div) else biggestPrimeFactor(n, div + 1, max)
      else biggestPrimeFactor(n, div + 1, max)
  println(biggestPrimeFactor(BigInt(600851475143L)))
}
