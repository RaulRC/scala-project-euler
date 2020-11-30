import scala.annotation.tailrec

/*
 * @project project-euler
 * @author raul.reguillo on 2020-11-30
 */

object Problem034 extends App{

  def factorial(n: Int): BigInt = {
    @tailrec
    def iteration(acc: BigInt, n: BigInt): BigInt = if (n <= 1) acc else iteration(n * acc, n-1)
    iteration(BigInt(1), n)
  }

  def isEqual(n: Int): Boolean =
    n.toString.map( x => factorial(x.asDigit) ).sum == n

  println(
  (145 to 100000).filter(isEqual).sum
  )
}
