package example

trait Printable[A] {
  def format(a: A): String

  // TODO 04: implement the contramap function
  // The 'contramap' allow to prepend a transformation before an operation
  def contramap[B](f: B => A): Printable[B] =
    (b: B) => format(f(b))
}

object PrintableInstances {

  // TODO 02: define a printable of 'String'
  implicit val printableString = new Printable[String] {
    def format(a: String): String = s"value=$a"
  }

  // TODO 02: define a printable of 'Int'
  implicit val printableInt = new Printable[Int] {
    def format(a: Int): String = s"value=${a.toString}"
  }

  // TODO 04: define a printable of 'Boolean'
  implicit val printableBoolean = new Printable[Boolean] {
    def format(a: Boolean): String = if (a) "yes" else "no"
  }

  // TODO 02: define a printable of 'Chat'
  implicit val printableCat = new Printable[Chat] {
    def format(a: Chat): String =
      s"name=${a.name}, age=${a.age}, color=${a.color}"
  }

}

object Printable {
  // TODO 02: complete the format function to accept an implicit printable
  def format[A](a: A)(implicit p: Printable[A]): String =
    p.format(a)
}

object PrintableSyntax {
  // TODO 02: define a class PrintableOps[A] to add 'format' to 'A'
  implicit class PrintableOps[A](a: A) {
    def format(implicit p: Printable[A]): String = p.format(a)
  }
}
