package example

final case class Cat(name: String, age: Int, color: String)

object Cat {
  import cats.Eq
  import cats.syntax.eq._
  import cats.instances.string._
  import cats.instances.int._

  implicit val catEquality = new Eq[Cat] {
    def eqv(x: Cat, y: Cat): Boolean = {
      (x.name === y.name) &&
      (x.age === y.age) &&
      (x.color === y.color)
    }
  }
}
