package example

case class Order(totalCost: Double, quantity: Double)

object Order {
  import cats.Monoid

  // TODO: define a monoid on Order
  implicit val orderMonoid = new Monoid[Order] {
    def empty = Order(totalCost = 0, quantity = 0)
    def combine(x: Order, y: Order): Order =
      Order(
        totalCost = x.totalCost + y.totalCost,
        quantity = x.quantity + y.quantity
      )
  }

}

object Calculator {

  import cats.Monoid

  // TODO: implement the generic add on any monoid
  def add[A](items: List[A])(implicit m: Monoid[A]): A = {
    import cats.syntax.semigroup._
    items.foldLeft(Monoid[A].empty)(_ |+| _)
  }
}
