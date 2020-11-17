/* 
 * @project project-euler
 * @author raul.reguillo on 2020-11-17
 */

object Problem025 extends App{

  val N_DIGITS = 1000

  var preLast :BigInt = 1
  var last :BigInt = 1
  var current :BigInt = last + preLast
  var n :Int = 3

  while (current.toString.length < N_DIGITS) {
    preLast = last
    last = current
    current = preLast + last
    n += 1
  }
  println(n)
}
