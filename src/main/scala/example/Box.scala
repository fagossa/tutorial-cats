package example

final case class Box[A](value: A)

object Box {

  /* TODO 04:
   * define an implicit conversion that receives an implicit Printable[A] to
   * transform a Box[A] into an A using Printable.contramap
   */
  //implicit def printableBox[A](...) = ???
}
