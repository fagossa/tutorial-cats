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
