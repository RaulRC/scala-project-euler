/* 
 * @project project-euler
 * @author raul.reguillo on 1/27/21
 */

object Problem062 extends App{
  val LENGTH = 5

  def search (n: Long, cubes: Map[Long, List[Long]]): Long = {
    val cube = n * n * n
    val key = cube.toString.sortWith(_>_).toLong
    val permutations = cube :: cubes.getOrElse(key, Nil)

    if (permutations.length == LENGTH)
      permutations.last
    else
      search(n + 1, cubes + (key -> permutations))
  }

  println(
    search(1, Map())
  )
}
