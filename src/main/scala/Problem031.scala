/* 
 * @project project-euler
 * @author raul.reguillo on 2020-11-25
 */

object Problem031 extends App{
  val REMAIN = 200
  def permutations(remain :Int, coins :List[Int]) :Int =
    if (remain == 0) 1
    else
      coins match {
        case Nil => 0
        case h::t => 0 to (remain/h) map(q => permutations(remain - q * h, t)) sum
    }
  println(
    permutations(REMAIN, List(200, 100, 50, 20, 10, 5, 2, 1))
  )
}
