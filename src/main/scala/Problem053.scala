/* 
 * @project project-euler
 * @author raul.reguillo on 1/14/21
 */

object Problem053 extends App{

  val LIMIT = 1000000

  def factorial(n: BigInt): BigInt =
    if (n < 2)
      1
    else
      n * factorial(n-1)

  def combinations(n: BigInt, r: BigInt): BigInt =
    factorial(n)/(factorial(r)*factorial(n-r))

  println(
    (for (n <- 1 to 100;
          r <- 1 to n
          if combinations(n, r) > LIMIT
    ) yield 1).sum
  )
}
