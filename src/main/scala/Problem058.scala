import scala.annotation.tailrec

/*
 * @project project-euler
 * @author raul.reguillo on 1/21/21
 */

object Euler058 extends App {

  def isPrimeTail(n: Int): Boolean = {
    @tailrec
    def isDivisibleBy(a: Int, b: Int): Boolean =
      if (b > 1) (a % b == 0) || isDivisibleBy(a, b-1) else false
    !isDivisibleBy(n, n/2)
  }

  def checkSpiral(r: Int, primes: Int, n: Int): Int = {
    if (primes * 10/n < 1)
      2 * r - 1
    else {
      val skip = 2 * r
      val base = (skip - 1) * (skip - 1)
      val rp = List(1, 2, 3).map(base + skip * _).count(isPrimeTail)
      checkSpiral(r + 1, primes + rp, n + 4)
    }
  }
  println(
    checkSpiral(2, 3, 5)
  )
}

object Euler058b extends App {

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

  val sieve = Sieve(100000)

  var k = 0
  var count = 0

  while (k < 10 || 10*count >= 4*k + 5) {
    count += (0 to 3).count( m =>
      sieve.isPrime(4*k*k + 12*k + 9 - 2*(k+1)*m)
    )
    k += 1
  }

  println((k+1)*2 + 1)
}