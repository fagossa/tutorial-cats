package example

final case class Gato(name: String, age: Int, color: String)

object Gato {
  import cats.Eq
  import cats.syntax.eq._
  import cats.instances.string._
  import cats.instances.int._

  // TODO: define equality
  implicit val catEquality = new Eq[Gato] {
    def eqv(x: Gato, y: Gato): Boolean = {
      (x.name === y.name) &&
      (x.age === y.age) &&
      (x.color === y.color)
    }
  }

  // This function is here is only to avoid the clash with scalatest!
  // TODO: use the function '===' to compare cats
  def isEqual(first: Gato, second: Gato) =
    first === second
}
