/* 
 * @project project-euler
 * @author raul.reguillo on 2020-11-05
 */

object Problem018 extends App{
  val BASE_LENGTH = 15

  val triangle = List(
    4, 62, 98, 27, 23,  9, 70, 98, 73, 93, 38, 53, 60,  4, 23,
      63, 66,  4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31,
        91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48,
          70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57,
            53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14,
              41, 48, 72, 33, 47, 32, 37, 16, 94, 29,
                41, 41, 26, 56, 83, 40, 80, 70, 33,
                  99, 65,  4, 28,  6, 16, 70, 92,
                    88,  2, 77, 73,  7, 63, 67,
                      19,  1, 23, 75,  3, 34,
                        20,  4, 82, 47, 65,
                          18, 35, 87, 10,
                            17, 47, 82,
                              95, 64,
                                75
  )

  def fold (triangle: List[Int], base: List[Int]): Int =
    if (base.length == 1)
      base.head
    else
      fold(triangle.drop(base.length -1),
        List.range(0, base.length -1)
          .map(
            i => triangle(i) + math.max(base(i), base(i+1))
          )
      )

  println(
    fold(triangle.drop(BASE_LENGTH), triangle.slice(0, BASE_LENGTH))
  )

}
