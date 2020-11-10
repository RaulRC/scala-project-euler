import scala.annotation.tailrec

/*
 * @project project-euler
 * @author raul.reguillo on 2020-11-10
 */

object Problem020 extends App {
  val NUMBER = 100

  def factorial(n: Int): BigInt = {
    @tailrec
    def iteration(acc: BigInt, n: BigInt): BigInt = if (n <= 1) acc else iteration(n * acc, n-1)
    iteration(BigInt(1), n)
  }
  def factSumDigits(n: Int): Int = factorial(n).toString().split("").map(_.toInt).sum

  println(
    factSumDigits(NUMBER)
  )

}
