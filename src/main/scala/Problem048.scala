/*
 * @project project-euler
 * @author raul.reguillo on 12/23/20
 */

object Problem048 extends App{
  val LIMIT = 1000

  println(
    (1 to LIMIT).map(i => BigInt(i).pow(i)).sum.toString().takeRight(10)
  )
}
