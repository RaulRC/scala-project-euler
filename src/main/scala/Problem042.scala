import scala.io.Source

/*
 * @project project-euler
 * @author raul.reguillo on 12/15/20
 */

object Problem042 extends App{

  def readWords(file :String) : List[String] =
    Source.fromFile(file).getLines()
      .next.stripLineEnd.split(",").map(n => n.slice(1, n.length() - 1)).toList

  def wordValue(word: String): Int = word.foldLeft(0)((s, l) => s + (l - 'A' + 1))
  def triangle(n: Int): Int = n * (n + 1)/2

  println(
    readWords(file = "inputs/p042_words.txt")
      .map(wordValue).count(v => v == triangle(math.sqrt(2 * v).toInt))
  )

}
