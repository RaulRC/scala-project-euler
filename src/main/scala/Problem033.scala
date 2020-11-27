/* 
 * @project project-euler
 * @author raul.reguillo on 2020-11-27
 */

object Problem033 extends App{

  def isEqual(ratio :Double, rNumerator :Int, rDenominator :Int) :Boolean =
    (rDenominator > 0) && (ratio == rNumerator/rDenominator.doubleValue())

  val fractions = for {
    denominator <- List.range(10, 100)
    numerator <- List.range(10, denominator)

    if (numerator % 10 == denominator/10 &&
      isEqual(numerator/denominator.doubleValue(), numerator/10, denominator % 10)) ||
      (numerator/10 == denominator % 10 &&
        isEqual(numerator/denominator.doubleValue(), numerator % 10, denominator/10))

  } yield (numerator, denominator)

  val product = fractions.foldRight((1, 1))((b, a) => (b._1 * a._1, b._2 * a._2))

  println(
    product._2 / product._1
  )
}
