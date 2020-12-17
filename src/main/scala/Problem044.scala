/* 
 * @project project-euler
 * @author raul.reguillo on 12/17/20
 */

object Problem044 extends App{

  def pentNumber(n: Int): Int = n * (3 * n - 1)/2

  val pentagonals = Set() ++ List.range(1, 3000).map(pentNumber)

  def find (a: Int, b: Int): Int = {
    val pent_a = pentNumber(a)
    val pent_b = pentNumber(b)
    val d = pent_b - pent_a
    val s = pent_a + pent_b
    if (pentagonals.contains(d) && pentagonals.contains(s))
      d
    else if (a >= b)
      find(1, b + 1)
    else find(a + 1, b)
  }

  println(
    find(1,2)
  )

}
