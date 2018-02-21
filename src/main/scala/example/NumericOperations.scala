package example

import cats.data.Writer

object NumericOperations {

  /*
    Note:
    - This alias could be a good idea: `type Logged[A] = Writer[Vector[String], A]`
    - Now, magic happens: `1.pure[Logged]`
    - Anyways, this way also works: `1.writer(Vector.empty[String])`
    - x.mapWriten(x => x) :3
   */

  def slowly[A](body: => A): A =
    try body
    finally Thread.sleep(100)

  import cats.instances.vector._
  import cats.syntax.applicative._ //allows 'pure'

  /*
   * TODO 05: Rewrite this function to use the Writer monad
   * Note:
   * - You should return a Vector[String] containing each step
   * - remember to 'map' the value to write ;)
   */
  def factorial(n: Int): Int = {
    val ans: Int = slowly {
      if (n == 0) 1 else n * factorial(n - 1)
    }
    println(s"fact($n)")
    ans
  }

}
