package example

case class Order(totalCost: Double, quantity: Double)

object Order {
  import cats.Monoid

  // TODO 03: define a monoid on Order
  implicit val orderMonoid: Monoid[Order] = new Monoid[Order] {
    def empty = Order(totalCost = 0, quantity = 0)
    def combine(x: Order, y: Order): Order =
      Order(
        totalCost = x.totalCost + y.totalCost,
        quantity = x.quantity + y.quantity
      )
  }

}
