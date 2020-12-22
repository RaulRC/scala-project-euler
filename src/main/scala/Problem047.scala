/* 
 * @project project-euler
 * @author raul.reguillo on 12/22/20
 */

object Problem047 extends App{

  val factors = Array.fill(150000)(0)

  var i = 2

  while (i < factors.length) {
    for (j <- List.range(i + i, factors.length, i))
      factors(j) += 1
    do i += 1
    while (i < factors.length && factors(i) != 0)
  }

  println(
    1.to(factors.length-3).find(n => factors.slice(n, n + 4).mkString == "4444")
  )
}
