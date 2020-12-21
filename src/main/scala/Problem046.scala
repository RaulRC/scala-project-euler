import scala.annotation.tailrec

/*
 * @project project-euler
 * @author raul.reguillo on 12/21/20
 */

object Problem046 extends App{
  def isPrimeTail(n: BigInt): Boolean = {
    @tailrec
    def isDivisibleBy(a: BigInt, b: BigInt): Boolean =
      if (b > 1) (a % b == 0) || isDivisibleBy(a, b-1) else false
    !isDivisibleBy(n, n/2)
  }

  def isGoldbach(n :Int): Boolean = (1 to math.sqrt(n/2).toInt).exists(s => isPrimeTail(n -2 * s * s))

  def checkNumber(n :Int): Int =
    if (isPrimeTail(n) || isGoldbach(n))
      checkNumber(n+2)
    else
      n

  println(
    checkNumber(3)
  )
}
