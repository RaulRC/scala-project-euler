/* 
 * @project project-euler
 * @author raul.reguillo on 2020-10-14
 */

object Problem002 extends App {
  def fibonacci(n: BigInt): BigInt = {
    def fibonacciHelper(i: BigInt, last: BigInt, nextLast: BigInt): BigInt =
      if (i == n) last else fibonacciHelper(i + 1, last + nextLast, last)
    fibonacciHelper(2, 1, 1)
  }
  println(fibonacci(4e3.toInt))

}

