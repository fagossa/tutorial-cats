package example

case class Order(totalCost: Double, quantity: Double)

object Order {
  import cats.Monoid
  import cats.syntax.semigroup._ // |+|
  import cats.instances.int._ // for monoid
  import cats.instances.option._

  implicit val orderMonoid = new Monoid[Order] {
    def empty = Order(totalCost=0, quantity=0)
    def combine(x: Order, y: Order): Order =
      Order(
        totalCost = x.totalCost + y.totalCost,
        quantity = x.quantity + y.quantity
      )
  }

  def add[A](items: List[A])(implicit m: Monoid[A]): A =
    items.foldLeft(Monoid[A].empty)(_ |+| _)

}
