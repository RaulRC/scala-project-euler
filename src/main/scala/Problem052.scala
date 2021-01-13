/* 
 * @project project-euler
 * @author raul.reguillo on 1/13/21
 */

object Problem052 extends App{

  def haveSameDigits(original: Int, product: Int): Boolean =
    original.toString.map(x => x).toSet == product.toString.map(x => x).toSet

  def checkNumber(original: Int): Boolean = (2 to 6).forall(x => haveSameDigits(original, original * x))

  println(
    Stream.from(1).find(x => checkNumber(x))
  )
}
