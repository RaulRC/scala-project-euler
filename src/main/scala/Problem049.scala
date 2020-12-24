import scala.annotation.tailrec

/*
 * @project project-euler
 * @author raul.reguillo on 12/24/20
 */

object Problem049 extends App{

  val OFFSET = 3330

  def isPrimeTail(n: Int): Boolean = {
    @tailrec
    def isDivisibleBy(a: Int, b: Int): Boolean =
      if (b > 1) (a % b == 0) || isDivisibleBy(a, b-1) else false
    !isDivisibleBy(n, n/2)
  }

  def sort (n :Int) = n.toString.toList.sortWith(_<_).mkString.toInt
  def isMem(n :Int, nn :Int): Boolean = isPrimeTail(nn) && sort(nn) == sort(n)
  def isSequence(n :Int): Boolean = isMem(n, n + OFFSET) && isMem(n, n + 2 * OFFSET)
  def makeSequence(n :Int) = List(n, n + OFFSET, n+ 2 * OFFSET).mkString

  println(
    makeSequence(1488.to(10000 - 2 * OFFSET).filter(isPrimeTail).filter(isSequence).head)
  )
}
