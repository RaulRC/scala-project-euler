import scala.annotation.tailrec

/*
 * @project project-euler
 * @author raul.reguillo on 2020-10-21
 */

object Problem007 extends App{
  var numbers = List.range(2, 500000)
  var primes = List(2)
  while(primes.length < 10001) {
    numbers = numbers.filter((x) => (x % primes.head != 0))
    primes = numbers.head :: primes
  }
  println(primes.head)
}