package example

object Calculator {

  import cats.Monoid

  /*
   * TODO 03: implement the generic 'add' on any monoid
   * Note:
   * - accept a List of T
   * - accept an implicit monoid of T
   * - fold over the list
   * - combine the different T using |+|
   */
  def add[T](items: List[T])(implicit m: Monoid[T]): T = {
    ???
  }
}
