/* 
 * @project project-euler
 * @author raul.reguillo on 1/28/21
 */

object Problem063 extends App{
  def powers(n: Int): Int = Stream.from(1) prefixLength(p => BigInt(n).pow(p).toString.length == p)
  println(
    1 to 9 map powers sum
  )
}
