/* 
 * @project project-euler
 * @author raul.reguillo on 2020-12-10
 */

object Problem039 extends App{

  val LIMIT = 1000

  def solutions(p: Int): Int = p + LIMIT * (
    for {
      a <- List.range(1, p/2)
      b <- List.range(1, (p - a)/2 + 1)
      c <- List(p - a - b)
      if a * a + b * b == c * c
  } yield 1).length

  println(
    List.range(3, 1000).map(solutions).max % LIMIT
  )

}
