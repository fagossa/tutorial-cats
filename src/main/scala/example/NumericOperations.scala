package example

import cats.data.Writer

object NumericOperations {

  type Logged[A] = Writer[Vector[String], A]

  def slowly[A](body: => A): A =
    try body
    finally Thread.sleep(100)

  import cats.instances.vector._
  import cats.syntax.applicative._ //allows 'pure'

  /*
   * TODO 05: Rewrite this function to used the Writer monad
   * Note:
   * - You should return a Vector[String] containing each step
   */
  /*
  def factorial(n: Int): Int = {
    val ans: Int = slowly {
      if (n == 0) 1 else n * factorial(n - 1)
    }
    println(s"fact $n $ans")
    ans
  }
   */
  def factorial(n: Int): Writer[Vector[String], Int] = {
    val ans = slowly {
      if (n == 0) 1.pure[Logged]
      else {
        factorial(n - 1).map(value => n * value)
      }
    }
    ans.mapWritten(_ :+ s"fact($n)")
  }

}
