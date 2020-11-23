/* 
 * @project project-euler
 * @author raul.reguillo on 2020-11-23
 */

object Problem029 extends App{
  val LIMIT = 100
  println(
    (for (a <- 2 to LIMIT; b <- 2 to LIMIT) yield math.pow(a,b)).toSet.size
  )
}
