package example

trait Printable[A] {
  def format(a: A): String
  def print(a: A): Unit = println(format(a))
}

object PrintableInstances {

  implicit val printableString = new Printable[String] {
    def format(a: String): String = s"value=$a"
  }

  implicit val printableInt = new Printable[Int] {
    def format(a: Int): String = s"value=${a.toString}"
  }

  implicit val printableCat = new Printable[Cat] {
    def format(a: Cat): String =
      s"name=${a.name}, age=${a.age}, color=${a.color}"
  }

}

object Printable {
  def format[A](a: A)(implicit p: Printable[A]): String = p.format(a)

  def print[A](a: A)(implicit p: Printable[A]): Unit = p.print(a)
}

object PrintableSyntax {
  implicit class PrintableOps[A](a: A) {
    def format(implicit p: Printable[A]): String = p.format(a)
    def print(implicit p: Printable[A]): Unit = p.print(a)
  }
}
