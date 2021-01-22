import scala.io.Source

/*
 * @project project-euler
 * @author raul.reguillo on 1/22/21
 */

object Problem059 extends App{

  //noinspection SourceNotClosed
  val cipher = io.Source.fromFile("inputs/p059_cipher.txt")
    .mkString.trim.split(",").map(_.toInt).toVector

  val letters = 'a' to 'z'
  val vowels = "aeiou".map(_.toInt).toSet

  val (_, result) = (
    for {
      a <- letters.iterator
      b <- letters
      c <- letters

      m = cipher.zipWithIndex.map {
        case (s, i) => i % 3
        match {
          case 0 => s ^ a
          case 1 => s ^ b
          case 2 => s ^ c
        }
      }
    } yield m.count(vowels) -> m
    ).maxBy(_._1)

  println(result.sum)

}
