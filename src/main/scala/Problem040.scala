/* 
 * @project project-euler
 * @author raul.reguillo on 2020-12-11
 */

object Problem040 extends App {
  val LIMIT = 1000000

  val digits = (1 until LIMIT).flatMap(_.toString.map(_ - '0'))

  println(
    (0 until 6).foldRight(1)((i, b) => b * digits(math.pow(10, i).intValue - 1))
  )
}
