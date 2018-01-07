package example

import org.scalatest.{MustMatchers, WordSpec}

class MonoidSpec extends WordSpec with MustMatchers with OrderFixture {

  import cats.Monoid

  "Monoid" must {

    "allow Int" in {
      // TODO: add the import for 'int' monoids
      import cats.instances.int._

      Monoid[Int].combine(1, 2) must be(3)
      Monoid.apply[Int].combineAll(List(1, 2, 3)) must be(6)
      Monoid.apply[Int].combineN(1, 10) must be(10)

      Monoid[Int].combine(
        15,
        Monoid.apply[Int].empty
      ) must be(15)
    }

    "allow Strings" in {
      // TODO: add the import for 'string' monoids
      import cats.instances.string._
      Monoid[String].combine("hello", "world") must be("helloworld")
      Monoid.apply[String].combineAll(List("one", "two", "three")) must be("onetwothree")
      Monoid.apply[String].combineN("hello", 3) must be("hellohellohello")

      // TODO: add the import for 'option' syntax
      import cats.syntax.option._
      Monoid
        .apply[String]
        .combineAllOption(
          List("one", "two", "three")
        ) must be("onetwothree".some)
      Monoid
        .apply[String]
        .combineAllOption(List.empty[String]) must be(none[String])
    }

    "allow Order" in {
      // TODO: add the implicit monoid for Orders in the order companion opject
      Monoid[Order].combine(
        orderCosting70,
        orderCosting30
      ) must be(Order(100, 30))
    }

    "allow using orders in a generic way" in {
      val orders = List(
        Order(2.3, 1),
        Order(1.7, 1),
        Order(2.5, 1),
        Order(3.5, 1)
      )
      // TODO: implement the generic add
      Calculator.add(orders) must be(Order(10, 4))
    }

  }

}
