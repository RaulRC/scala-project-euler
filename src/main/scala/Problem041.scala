/* 
 * @project project-euler
 * @author raul.reguillo on 12/14/20
 */

object Problem041 extends App{

  val LIMIT = 8000000

  def isPandigital(number :String) :Boolean = number.sortWith(_<_) == (1 to number.length).map(_.toString).reduce(_+_)

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

  println(
    primes.filter(x=> isPandigital(x.toString())).max
  )
}
