package example

final case class Box[A](value: A)

object Box {

  /* TODO 04: define an implicit conversion that uses an implicit Printable[A] to
   * delegate the print with a 'contramap[Box[A]]'
   */
  implicit def printableBox[A](implicit p: Printable[A]) =
    p.contramap[Box[A]](_.value)
}
