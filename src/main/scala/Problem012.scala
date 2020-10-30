/*
 * @project project-euler
 * @author raul.reguillo on 2020-10-28
 */

object Problem012 extends App{
  val N_DIVISORS = 500

  val triangular = Stream.from(1).scan(0)(_ + _)
  def divisors(n: Int): Int = {
    val middleFactor = math.sqrt(n).intValue
    val smallFactors = (1 to middleFactor).count(n % _ == 0)
    2 * smallFactors - (if (middleFactor * middleFactor == n) 1 else 0)
  }
  println(
    triangular.find(divisors(_) > N_DIVISORS).head
  )
}
