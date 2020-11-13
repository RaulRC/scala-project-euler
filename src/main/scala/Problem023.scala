/* 
 * @project project-euler
 * @author raul.reguillo on 2020-11-13
 */
import scala.collection.Searching._

object Problem023 extends App{
  val LIMIT = 28123

  def isAbundant(n :Int): Boolean =
    List.range(1, n/2 + 1).filter(x => n % x == 0).sum > n

  val abundantNumbers = List.range(1, LIMIT).filter(isAbundant)

  println(
    (1 to LIMIT).filter(i => abundantNumbers.takeWhile( _ < i)
      .forall(
        j => abundantNumbers.search(i-j) match {
        case Found(_) => false
        case _ => true
      }
    )).sum
  )

}
