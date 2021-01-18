/* 
 * @project project-euler
 * @author raul.reguillo on 1/18/21
 */

object Problem055 extends App{
  def isPalindrome(n: String): Boolean = n.take(n.length/2) == n.takeRight(n.length/2).reverse

  def isLychrelNumber(n: BigInt, iter: Int = 0): Boolean =
    if (iter > 0 && isPalindrome(n.toString))
      false
    else if (iter == 50)
      true
    else
      isLychrelNumber(n + BigInt(n.toString.reverse), iter + 1)

  println(
    1 to 9999 map(n => isLychrelNumber(n)) count(x => x)
  )
}
