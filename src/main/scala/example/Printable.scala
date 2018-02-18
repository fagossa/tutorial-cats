package example

trait Printable[A] {
  def format(a: A): String

  // TODO 04: implement the contramap function
  // The 'contramap' allow to prepend a transformation before an operation
  // apply format to f
  def contramap[B](f: B => A): Printable[B] = ???
}

object PrintableInstances {

  // TODO 02: define a printable of 'Int'
  //implicit val printableInt = ???

  // TODO 02: define a printable of 'String'
  //implicit val printableString = ???

  // TODO 04: define a printable of 'Boolean'
  //implicit val printableBoolean = ???

  // TODO 02: define a printable of 'Gato'
  //implicit val printableCat = ???

}

object Printable {
  // TODO 02: complete the format function to accept an implicit printable to format a
  def format[A](a: A) = ???
}

object PrintableSyntax {
  // TODO 02: define a class PrintableOps[A] to add 'format' to 'A'
  implicit class PrintableOps[A](a: A) {
    // def format(...) = p.format(a)
  }
}
