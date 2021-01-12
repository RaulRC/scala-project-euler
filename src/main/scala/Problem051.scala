import scala.annotation.tailrec

/*
 * @project project-euler
 * @author raul.reguillo on 1/12/21
 */

object Problem051 extends App{

  def getPrimes (range: Int): Array[Int] = {
    val primes = Array.range(0, range)
    primes(1) = 0
    var index = 2

    while (index < range) {
      var aux = index + index
      while (aux < range) {
        primes(aux) = 0
        aux += index
      }
      do index +=1
      while (index < range && primes(index) == 0)
    }
    primes
  }

  def isPrimeTail(n: Int): Boolean = {
    @tailrec
    def isDivisibleBy(a: Int, b: Int): Boolean =
      if (b > 1) (a % b == 0) || isDivisibleBy(a, b-1) else false
    !isDivisibleBy(n, n/2)
  }

  def generateAndCount(n: String)(d: Char): Int = {
    val variants = "0123456789".toList.map(nd => n.replace(d, nd))
    variants.filter(!_.startsWith("0")).map(Integer.parseInt).count(isPrimeTail)
  }

  def count (prime: String): Int = prime.toSet.map(generateAndCount(prime)).max

  println(
    getPrimes(150000).find(p => count(p.toString) > 7).get
  )
}
