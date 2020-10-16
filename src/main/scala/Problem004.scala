/* 
 * @project project-euler
 * @author raul.reguillo on 2020-10-16
 */

object Problem004 extends App{
  def isPalindrome(n: String): Boolean = n.substring(0, n.length/2) == n.substring(n.length/2).reverse

  println((for (a <- 100 to 999; b <- 100 to 999
                if (isPalindrome(a * b toString)))
    yield a * b).max)
}
