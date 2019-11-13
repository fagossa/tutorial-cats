package example

import cats.Monoid

object Monoidal {
  def apply[A](implicit monoid: Monoid[A]) = monoid
}

object BooleanMonoidInstances {

  // TODO 03: implement ANDMonoid
  val ANDMonoid = new Monoid[Boolean] {
    def empty = true
    def combine(x: Boolean, y: Boolean): Boolean = x && y
  }

  // TODO 03: implement ORMonoid
  val ORMonoid = new Monoid[Boolean] {
    def empty = true
    def combine(x: Boolean, y: Boolean): Boolean = x || y
  }

}
