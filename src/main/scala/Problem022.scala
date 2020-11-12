import scala.io.Source

/*
 * @project project-euler
 * @author raul.reguillo on 2020-11-12
 */

object Problem022 extends App{
  def readLine (file :String) :String = {
    Source.fromFile(file).getLines().next.stripLineEnd
  }
  def readNames(file :String) :List[String] =
    readLine(file).split(',').map(n => n.slice(1, n.length-1)).toList.sortWith(_<_)

  val names = readNames(file = "inputs/p022_names.txt")

  def scoreName (name :String) :Int = name.foldLeft(0)((s, l) => s + (l - 'A' + 1))

  println(
    List.range(0, names.length)
      .map(i => (i + 1) * scoreName(names(i)))
      .sum
  )
}
