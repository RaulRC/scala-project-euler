/* 
 * @project project-euler
 * @author raul.reguillo on 2020-10-30
 */

object Problem014 extends App{
  val LIMIT = 1000000

  //def seq(n: Int): Stream[Int] = if (n == 1) Stream(n) else Stream.cons(n, if (n % 2 == 0) seq(n/2) else seq(3 * n+1))

  def seq(n: Long, c: Int = 0): Int =
    if (n == 1) c + 1
    else
      seq(
        if (n % 2 == 0) n / 2
        else 3 * n + 1,
        c + 1)

  val r = (1 until LIMIT).view.map(n => (n, seq(n))).reduceLeft((a, b) => if (a._2 > b._2) a else b)._1

  println(r)
}
