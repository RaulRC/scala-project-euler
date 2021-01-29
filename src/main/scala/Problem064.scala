/* 
 * @project project-euler
 * @author raul.reguillo on 1/29/21
 */

object Problem064 extends App{
  val LIMIT = 10000

  case class Root (root: Int, add: Int, div: Int) {
    def expand: (Int, Root) = {
      val term = ((math.sqrt(root) + add)/div).toInt
      val nadd = term * div - add
      (term, Root(root, nadd, (root - nadd * nadd)/div))
    }
    override def toString: String = "(√" + root + "+" + add + ")/" + div
  }
  def expansion (terms: List[Int], roots: List[Root]): List[Int] = {
    val (term, root) = roots.head.expand
    if (root.div == 0 || roots.contains(root)) term :: terms
    else expansion(term :: terms, root :: roots)
  }
  println(
    1 to LIMIT map(n => expansion(Nil, Root(n, 0, 1):: Nil).length) count(_ % 2 == 0)
  )

}
