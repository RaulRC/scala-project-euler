/* 
 * @project project-euler
 * @author raul.reguillo on 12/18/20
 */

object Problem045 extends App{

  def findHexagonal(pent: Long, h: Long): Long = {
    val hex = h * (2 * h - 1)
    if (hex > pent)
      findHexagonal(pent, h - 1)
    else if (hex < pent)
      0
    else
      hex
  }
  def findPentagonal(tri: Long, p: Long): Long = {
    val pent = p * (3 * p - 1)/2
    if (pent > tri)
      findPentagonal(tri, p - 1)
    else if (pent < tri)
      0
    else
      findHexagonal(pent, p - 1)
  }

  def triangular(n: Long): Long = n * (n + 1)/2

  println(
    Stream.from(286).map(t => findPentagonal(triangular(t.toLong), t - 1)).find(_ != 0).get
  )
}
