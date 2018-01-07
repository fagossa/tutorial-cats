package example

final case class Chat(name: String, age: Int, color: String)

object Chat {
  import cats.Eq
  import cats.syntax.eq._
  import cats.instances.string._
  import cats.instances.int._

  // TODO: define equality
  implicit val catEquality = new Eq[Chat] {
    def eqv(x: Chat, y: Chat): Boolean = {
      (x.name === y.name) &&
      (x.age === y.age) &&
      (x.color === y.color)
    }
  }

  // This function is here is only to avoid the clash with scalatest!
  // TODO: use the function '===' to compare cats
  def isEqual(first: Chat, second: Chat) =
    first === second
}
