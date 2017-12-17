package example

import cats.Monoid

object Monoidal {
  def apply[A](implicit monoid: Monoid[A]) = monoid
}

object BooleanMonoidInstances {
  val ANDMonoid = new Monoid[Boolean] {
    def empty = true
    def combine(x: Boolean, y: Boolean) = x && y
  }

  val ORMonoid = new Monoid[Boolean] {
    def empty = true
    def combine(x: Boolean, y: Boolean) = x || y
  }

  // others
}

object MonoidExample extends App {
  import BooleanMonoidInstances._
  mustBeEqual(Monoidal(ANDMonoid).combine(true, true), true)
  mustBeEqual(Monoidal(ORMonoid).combine(false, true), true)

  import cats.syntax.semigroup._ //|+|
  import cats.instances.string._

  val stringResult = "Hello" |+| "World" |+| Monoid[String].empty
  mustBeEqual(stringResult, "HelloWorld")

  // adding numbers
  import cats.instances.int._
  import cats.instances.option._
  mustBeEqual(Order.add(List(1, 2, 3, 4)), 10)

  import cats.syntax.option._
  mustBeEqual(Order.add(List(1.some, 2.some, 3.some, 4.some)), 10.some)

  // adding orders
  mustBeEqual(
    Order.add(
      List(
        Order(2.3, 1),
        Order(1.7, 1),
        Order(2.5, 1),
        Order(3.5, 1)
      )
    ),
    Order(10, 4)
  )
}
