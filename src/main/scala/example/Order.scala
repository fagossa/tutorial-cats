package example

case class Order(totalCost: Double, quantity: Double)

object Order {
  import cats.Monoid

  // TODO 03: define a monoid on Order
  //implicit val orderMonoid = ???

}
