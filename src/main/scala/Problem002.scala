/* 
 * @project project-euler
 * @author raul.reguillo on 2020-10-14
 */

object Problem002 extends App {
  def fibSum (a :Int, b :Int) :Int =
    (if (b % 2 == 0) b else 0) + (if (a+b > 4000000) 0 else fibSum(b, a + b))
  def answer : Int = fibSum(1, 2)
  println(answer)

}

