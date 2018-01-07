package example

trait Printable[A] {
  def format(a: A): String
  def print(a: A): Unit = println(format(a))
}

object PrintableInstances {

  // TODO: define a printable of 'String'
  implicit val printableString = new Printable[String] {
    def format(a: String): String = s"value=$a"
  }

  // TODO: define a printable of 'Int'
  implicit val printableInt = new Printable[Int] {
    def format(a: Int): String = s"value=${a.toString}"
  }

  // TODO: define a printable of 'Chat'
  implicit val printableCat = new Printable[Chat] {
    def format(a: Chat): String =
      s"name=${a.name}, age=${a.age}, color=${a.color}"
  }

}

object Printable {
  // TODO: complete the format function to accept an implicit printable
  def format[A](a: A)(implicit p: Printable[A]): String =
    p.format(a)
}

object PrintableSyntax {
  // TODO define a PrintableOps[A]
  implicit class PrintableOps[A](a: A) {
    def format(implicit p: Printable[A]): String = p.format(a)
    def print(implicit p: Printable[A]): Unit = p.print(a)
  }
}
