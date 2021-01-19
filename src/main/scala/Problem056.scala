/* 
 * @project project-euler
 * @author raul.reguillo on 1/19/21
 */

object Problem056 extends App{
  val START = 90
  val LIMIT = 100
  println(
    (
      for{
        a <- START to LIMIT
        b <- START to LIMIT
      } yield BigInt(a).pow(b).toString.map(_-'0').sum
    ).max
  )
}
