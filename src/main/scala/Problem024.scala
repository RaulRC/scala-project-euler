/* 
 * @project project-euler
 * @author raul.reguillo on 2020-11-16
 */

object Problem024 extends App{

  val POSITION = 1000000
  val nthNumber = List("0", "1", "2", "3", "4", "5", "6", "7", "8", "9").permutations.toList(POSITION-1).mkString("")

  println(
    nthNumber
  )
}
