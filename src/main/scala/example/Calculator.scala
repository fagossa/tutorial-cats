package example

object Calculator {

  import cats.Monoid

  // TODO: implement the generic add on any monoid
  def add[T](items: List[T])(implicit m: Monoid[T]): T = {
    import cats.syntax.semigroup._
    items.foldLeft(Monoid[T].empty)(_ |+| _)
  }
}
