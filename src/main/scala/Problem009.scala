/* 
 * @project project-euler
 * @author raul.reguillo on 2020-10-23
 */

object Problem009 extends App{
  val limit = 1000
  println(
    (for {
    a <- 1 to limit
    b <- 1 to limit
    c <- 1 to limit
    if a*a + b*b == c*c && a + b + c == limit
    } yield (a, b, c, a*b*c)).head)
}
