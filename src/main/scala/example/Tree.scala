package example

import cats.Functor

sealed trait Tree[+A]

final case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

final case class Leaf[A](value: A) extends Tree[A]

object Tree {

  // TODO 04: implement Functor[Tree]
  //implicit val treeFunctor = ???

}
