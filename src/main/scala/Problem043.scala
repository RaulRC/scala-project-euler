/* 
 * @project project-euler
 * @author raul.reguillo on 12/16/20
 */

object Problem043 extends App{

  def digits (n: Int): List[Int] = n.toString.toList.map(_ - '0')

  def computeSum(n: Long, digits: Set[Int], divs: List[Int], sum: Long): Long =
    if (digits.isEmpty)
      n + sum
    else (
      for (dig <- digits;
           numb = n * 10 + dig;
           if (numb % 1000) % divs.head == 0)
              yield computeSum(numb, digits filterNot(_ == dig), divs.tail, sum))
      .sum

  def compute (s: Int): Long =
    computeSum(
      s,
      digits = (0 to 9).toSet -- digits(s),
      divs = List(2, 3, 5, 7, 11, 13, 17),
      sum = 0)

  println(
    100 to 999 filter(n => digits(n).distinct == digits(n)) map compute sum
  )

}
