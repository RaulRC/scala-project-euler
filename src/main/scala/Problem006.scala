/* 
 * @project project-euler
 * @author raul.reguillo on 2020-10-20
 */

object Problem006 extends App{
  val limit = 100
  println(
    (scala.math.pow((1 to limit).sum, 2) - (1 to limit).map(x => x * x).sum).toLong
  )
}
