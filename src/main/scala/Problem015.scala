/* 
 * @project project-euler
 * @author raul.reguillo on 2020-11-02
 */

object Problem015 extends App{
  val SIZE = 20
  def fact(n: BigInt): BigInt = if (n == 0) 1 else n * fact(n - 1)
  def solve(size: BigInt): BigInt = fact(size * 2)/(fact(size) * fact(size))
  println(solve(SIZE))
}
