import scala.annotation.tailrec
import scala.collection.mutable.{BitSet => MBitSet, ArrayBuffer}
/*
 * @project project-euler
 * @author raul.reguillo on 1/25/21
 */

object Problem060 extends App{

  val biggest = 1100

  case class Sieve(n: Int) {
    private val size = (n - 3) / 2

    private val sieve =
      collection.mutable.BitSet() ++ (0 to size)

    private val root = (math.sqrt(n).toInt - 3) / 2
    for {
      i <- 0 to root
      if sieve(i)
      p = 2*i + 3
      j <- i*(p+3)+3 to size by p
    } sieve(j) = false

    lazy val primes: IndexedSeq[Int] =
      2 +: sieve.toVector.map(2*_ + 3)

    def primeCount(num: Int): Int = {
      import collection.Searching._

      primes.search(num) match {
        case Found(i) => i + 1
        case InsertionPoint(i) => i
      }
    }

    def primesIter() =
      Iterator(2) ++ sieve.iterator.map(2*_ + 3)

    def primesIter(from: Int): Iterator[Int] = {
      val it = sieve.iteratorFrom(((from - 2) / 2).toInt).map(2*_ + 3)
      if (from > 2) it else Iterator(2) ++ it
    }

    def oddCompositesIter(from: Int = 9): Iterator[Int] =
      (((from - 2) / 2).toInt to size).iterator.filterNot(sieve).map(2*_ + 3)

    def numberOfDivisors(num: Int, power: Int = 1): Int = {
      var n = num
      var result = 1
      primes.takeWhile( p =>
        n != 1 && p*p <= n
      ).foreach { p =>
        var cur = 1
        while(n % p == 0) {
          n /= p
          cur += power
        }
        result *= cur
      }
      if (n != 1)
        result *= power + 1
      result
    }

    def isPrime(num: Long): Boolean =
      if (num <= 2)
        num == 2
      else if (num <= n)
        num%2 == 1 && sieve(((num - 3) / 2).toInt)
      else if (num <= n.toLong*n) {
        val root = math.sqrt(num).toInt
        primes.takeWhile(_ <= root).forall(num % _ != 0)
      } else throw new Exception(s"Cannot check $num for primality in sieve of size $n.")
  }

  val p = Sieve(85000000).primes

  var current = {
    val check = p.toSet
    for {
      i <- 0 to biggest
      j <- i+1 to biggest
      if check(("" + p(i) + p(j)).toInt)
      if check(("" + p(j) + p(i)).toInt)
    } yield List(j, i)
  }

  val friends = current.map {
    case List(j, i) => (i, j)
  }.toSet

  (3 to 5).foreach { _ =>
    current = for {
      group <- current
      candidate <- group.head+1 to biggest
      if group.forall(friends(_, candidate))
    } yield candidate :: group
  }

  require(current.size == 1)
  val result = current.head.map(p)

  println(
    result.sum
  )
}
