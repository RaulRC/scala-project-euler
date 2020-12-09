/* 
 * @project project-euler
 * @author raul.reguillo on 2020-12-09
 */

object Problem038 extends App{
  def isPandigital(n :String) :Boolean = n.sortWith(_<_) == "123456789";

  println(
    (9182 to 9876).reverse.map(n => n + "" + (2 * n)).find(isPandigital).get
  )

}
