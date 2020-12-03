/* 
 * @project project-euler
 * @author raul.reguillo on 2020-12-03
 */

object Problem036 extends App{

  val LIMIT = 1000000

  def isPalindrome(n :String): Boolean = n.reverse.sameElements(n)

  def isDoubleBasePalindrome(n :Int): Boolean  = isPalindrome(n.toString) && isPalindrome(n.toBinaryString)

  println(
    (1 until LIMIT by 2) filter isDoubleBasePalindrome sum
  )
}
