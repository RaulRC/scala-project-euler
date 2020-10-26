

/*
 * @project project-euler
 * @author raul.reguillo on 2020-10-26
 */

object Problem010 extends App{

  val LIMIT = 2000000

  def odds(n:Long): Stream[Long] = Stream.cons(n,odds(n + 2))

  def isPrime(n:Long): Boolean =
    (primes takeWhile { _ <= math.floor(math.sqrt(n)) }) forall { n % _ != 0 }
  lazy val primes: Stream[Long] = Stream.cons(2,odds(3) filter isPrime)
  println(
    (primes takeWhile { _ < LIMIT }).toList.sum
  )
}

