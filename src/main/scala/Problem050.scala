/* 
 * @project project-euler
 * @author raul.reguillo on 1/11/21
 */

object Problem050 extends App {
  
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
  
  case class PrimeSum(sum :Int, length :Int) {
    def add (prime :Int) = PrimeSum(sum + prime, length+1)
  }

  val primesVector = getPrimes(LIMIT)
  val primes = primesVector.filter(_ != 0)

  def sumFunction(idx: Int, csum: PrimeSum, lsum: PrimeSum): PrimeSum = {
    if (idx >= primes.length || csum.sum >= primesVector.length)
      lsum
    else
      sumFunction(idx+1, csum.add(primes(idx)),
        if (primesVector(csum.sum) != 0) csum
        else lsum
      )
  }

  def longer (one :PrimeSum, two :PrimeSum): PrimeSum = if (one.length > two.length) one else two

  println(
    primes.indices.map(sumFunction(_, PrimeSum(0, 0), PrimeSum(0, 0))).reduceLeft(longer).sum
  )

}