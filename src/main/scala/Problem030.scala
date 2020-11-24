/* 
 * @project project-euler
 * @author raul.reguillo on 2020-11-24
 */

object Problem030 extends App{
  val LIMIT = 300000
  def digits (n :Int) :Array[Int] = n.toString.split("").map(_.toInt)
  def isSum(n :Int) :Boolean = digits(n).map(a => math.pow(a, 5).toInt).sum == n

  println(
    (2 until LIMIT) filter(isSum) sum
  )
}
