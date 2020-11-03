/* 
 * @project project-euler
 * @author raul.reguillo on 2020-11-03
 */

object Problem016 extends App{
  val POW = 1000
  val BASE = 2

  println(
    BigInt(BASE).pow(POW)
    .toString()
    .split("").map(_.toInt).reduce(_ + _)
  )
}
