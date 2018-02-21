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
  def validateUser(params: FormData): Validated[List[String], User] =
    (
      readName(params).toValidated,
      readAge(params).toValidated
    ).mapN(User.apply)

  /*
   * TODO 07: implement this function
   * Note:
   * - call getValue
   * - call nonBlank
   */
  def readName(params: FormData): ErrorOr[String] =
    for {
      value <- getValue("name")(params)
      result <- nonBlank("name")(value)
    } yield result

  /*
   * TODO 07: implement this function
   * Note:
   * - call getValue
   * - call nonBlank
   * - call parseInt
   * - call nonNegative
   */
  def readAge(params: FormData): ErrorOr[Int] =
    for {
      value <- getValue("age")(params)
      nb <- nonBlank("age")(value)
      age <- parseInt("age")(nb)
      result <- nonNegative(age)
    } yield result

  /*
   * TODO 07: implement this function
   */
  private def getValue(name: String)(data: FormData): ErrorOr[String] =
    data
      .get(name)
      .toRight(List(s"$name is not present"))

  private def parseInt(name: String)(data: String): ErrorOr[Int] =
    Either
      .catchOnly[NumberFormatException](data.toInt)
      .leftMap(_ => List(s"$name must be an integer"))

  private def nonBlank(name: String)(data: String): ErrorOr[String] =
    data
      .asRight[List[String]]
      .ensure(List(s"$name is blank"))(_.nonEmpty)

  private def nonNegative(data: Int): ErrorOr[Int] =
    Either.cond(
      data >= 0,
      data,
      List("Negative value")
    )

}
