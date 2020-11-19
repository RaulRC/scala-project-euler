import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.{BitSet => MBitSet, ArrayBuffer}

/*
 * @project project-euler
 * @author raul.reguillo on 2020-11-19
 */

object Problem027 extends App{

  val MAX = 80
  val TOP = 1000

  def getPrimes (range :Int) :Array[Int] = {
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

  var euForm = (m :Int, t :Int) => m * m + m * t + t
  var quadForm = (n: Int, a :Int, b:Int) => n * n + a * n + b

  val primes = getPrimes(euForm(MAX, TOP))

  def polyPrimes(primes :Array[Int], a :Int, b :Int, n :Int) :Int =
    if (primes(math.abs(quadForm(n, a, b))) == 0)
      0
    else
      1 + polyPrimes(primes, a, b, n+1)

  val result = for {
    a <- -TOP + 1 until TOP
    b <- -TOP to TOP
    p = polyPrimes(primes, a, b, 0) if (p > 0)
  } yield (a * b, p)

  println(
    result.foldLeft((0, 0))((a, b) =>
      if (a._2 > b._2)
        a
      else b
    )._1
  )
}
