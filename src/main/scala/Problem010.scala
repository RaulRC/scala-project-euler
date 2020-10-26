

/*
 * @project project-euler
 * @author raul.reguillo on 2020-10-26
 */

object Problem010 extends App{
  val TOP = 2000000
  var numbers = List.range(2, TOP)
  var primes = List(2)
  while(numbers.nonEmpty) {
    numbers = numbers.filter(x => x % primes.head != 0)
    if(numbers.nonEmpty)
    primes = numbers.head :: primes
  }
  println(primes.sum)
}