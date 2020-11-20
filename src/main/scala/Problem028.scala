/* 
 * @project project-euler
 * @author raul.reguillo on 2020-11-20
 */

object Problem028 extends App{
  val SIZE = 1001

  def spiral (size :Int) :Int = {
    val stepSize = size - 2
    if (size == 1)
      1
    else
      spiral(stepSize) + 4 * (stepSize * stepSize) + (1 + 2 + 3 + 4) * (stepSize + 1)
  }

  println(
    spiral(size=SIZE)
  )
}
