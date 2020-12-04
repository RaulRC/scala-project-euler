/* 
 * @project project-euler
 * @author raul.reguillo on 2020-12-04
 */

object Problem037 extends App{

  val LIMIT = 8000000

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

  var primes = getPrimes(LIMIT)

  def isRightTruncable(prime :Int): Boolean =
    (prime == 0) || ((primes(prime) != 0) && isRightTruncable(prime/10))

  def isLeftTruncable(prime :String): Boolean =
    prime.isEmpty || ((primes(prime.toInt) != 0) && isLeftTruncable(prime.substring(1)))

  def isTruncable(prime :Int): Boolean = isRightTruncable(prime) && isLeftTruncable(prime.toString)

  println(
    primes.drop(10).filter(_ != 0).filter(isTruncable).sum
  )
}
