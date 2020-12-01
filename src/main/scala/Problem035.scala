/* 
 * @project project-euler
 * @author raul.reguillo on 2020-12-01
 */

object Problem035 extends App{
  val LIMIT = 1000000

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
  val primes = getPrimes(LIMIT)

  def countDigits(value :Int) :Int = if (value == 0) 0 else 1 + countDigits(value/10)

  def rotate(n: Int, rotations: Int) :Int = {
    val mod = math.pow(10, countDigits(n)-rotations).intValue()
    (n % mod) * math.pow(10, rotations).intValue() + (n / mod)
  }

  def isCircular(n: Int): Boolean =
      (0 to countDigits(n)).foldRight(true)((t, b) => b && (primes(rotate(n, t)) != 0))

  println(
    primes.count(x => isCircular(x) && x != 0)
  )

}
