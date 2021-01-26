/* 
 * @project project-euler
 * @author raul.reguillo on 1/26/21
 */

object Problem061 extends App{
  
  case class Pn (card: Int, value: Int) {
    def isValidNumber: Boolean = (value > 999) && (value < 10000)
    def ab: Int = value / 100
    def cd: Int = value % 100
  }

  def tri(n: Int) = Pn(3, n*(n+1)/2)
  def square (n: Int) = Pn(4, n*n)
  def penta(n: Int) = Pn(5, n*(3*n-1)/2)
  def hexa(n: Int) = Pn(6, n*(2*n-1))
  def hepta(n: Int) = Pn(7, n*(5*n-3)/2)
  def octa(n: Int) = Pn(8, n*(3*n-2))

  def gen(max: Int)(gen: Int => Pn): IndexedSeq[Pn] =
    (1 to max) map gen filter(_.isValidNumber)

  val nums = List(square _, penta _, hexa _, hepta _, octa _) flatMap gen(max = 100)

  def search (numbers: Seq[Pn], set: List[Pn]): Option[List[Pn]] =
    if (numbers.isEmpty)
      Some(set) filter(x => x.last.cd == x.head.ab)
    else
      numbers filter (_.ab == set.last.cd) flatMap (
        n => search(numbers filter (_.card != n.card), set :+ n)) headOption

  def sets: IndexedSeq[List[Pn]] = gen( max =150)(tri) flatMap (n => search(nums, n :: Nil))
  
  println(
    (sets head) map(_.value) sum
  )

}
