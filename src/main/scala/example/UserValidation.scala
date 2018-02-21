package example

import cats.data.Validated

case class User(name: String, age: Int)

object UserValidation {
  /*
   * Validations:
   * - The name and age must be specified
   * - The name must not be blank
   * - The age must be a positive integer
   *
   * Things you could use:
   * - Either.catchOnly[MyException](toto)
   * - Either.leftMap(_.toString)
   * - Option::Right e.g. val t: Either[String, Int] = Option(42).toRight("Error")
   * - 1.asRight[String].ensure("Even")(_ % 2 != 0)
   * - Either.cond(i % 2 != 0, i, "Even")
   */

  type FormData = Map[String, String]
  type ErrorOr[A] = Either[List[String], A]

  import cats.instances.list._ // for semigroupal

  import cats.syntax.either._
  import cats.syntax.apply._ // for mapN

  /*
   * TODO 07: implement this function
   * Note:
   * - call readName and readAge and transform its results into Validated[U, T]
   * - create a tuple with the results
   * - call mapN on the tuple to build an instance of User (e.g. using apply)
   */
  def validateUser(params: FormData): Validated[List[String], User] = ???

  /*
   * TODO 07: implement this function
   * Note:
   * - call getValue
   * - call nonBlank
   */
  def readName(params: FormData): ErrorOr[String] = ???

  /*
   * TODO 07: implement this function
   * Note:
   * - call getValue
   * - call nonBlank
   * - call parseInt
   * - call nonNegative
   */
  def readAge(params: FormData): ErrorOr[Int] = ???

  /*
   * TODO 07: implement this function
   */
  private def getValue(name: String)(data: FormData): ErrorOr[String] = ???

}
