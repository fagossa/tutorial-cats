package example

import cats.Monoid

object Monoidal {
  def apply[A](implicit monoid: Monoid[A]) = monoid
}

object BooleanMonoidInstances {

  // TODO 03: implement ANDMonoid
  //val ANDMonoid = ???

  // TODO 03: implement ORMonoid
  //val ORMonoid = ???

}
