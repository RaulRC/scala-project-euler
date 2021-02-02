/* 
 * @project project-euler
 * @author raul.reguillo on 2/2/21
 */
import scala.collection.mutable.{Map => MMap}

object Problem066 extends App{
  def leastx (d: Int): BigInt = {
    val amap = MMap[Int,BigInt]()
    val pmap = MMap[Int,BigInt]()
    val qmap = MMap[Int,BigInt]()
    val ppmap = MMap[Int,BigInt]()
    val qqmap = MMap[Int,BigInt]()

    def a (i: Int): BigInt = amap.getOrElseUpdate(i, i match {
      case 0 => math.sqrt(d).toInt
      case _ => (a(0) + pp(i))/qq(i)
    })

    def p (i: Int): BigInt = pmap.getOrElseUpdate(i, i match {
      case 0 => a(0)
      case 1 => a(0)*a(1) + 1
      case _ => a(i)*p(i-1) + p(i-2)
    })

    def q (i: Int): BigInt = qmap.getOrElseUpdate(i, i match {
      case 0 => 1
      case 1 => a(1)
      case _ => a(i)*q(i-1) + q(i-2)
    })

    def pp (i: Int): BigInt = ppmap.getOrElseUpdate(i, i match {
      case 0 => 0
      case 1 => a(0)
      case _ => a(i-1)*qq(i-1) - pp(i-1)
    })

    def qq (i: Int): BigInt = qqmap.getOrElseUpdate(i, i match {
      case 0 => 1
      case 1 => BigInt(d) - a(0)*a(0)
      case _ => (BigInt(d) - pp(i)*pp(i))/qq(i-1)
    })

    val as = Stream.from(0) map a
    val r = as.tail takeWhile(ai => ai != as.head*2) length

    if (r % 2 == 1) p(r) else p(2*r+1)
  }

  def square (i: Int): Int = i*i
  def isSquare(d: Int): Boolean = square(math.sqrt(d).toInt) == d

  println(
    (2 to 1000 filterNot isSquare map (d => (d, leastx(d))) maxBy (_._2))._1
  )


}
