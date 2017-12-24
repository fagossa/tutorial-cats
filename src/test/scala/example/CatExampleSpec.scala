package example

import org.scalatest.{MustMatchers, WordSpec}

class CatExampleSpec extends WordSpec with MustMatchers {

  import cats.Monoid

  "Printable" must {
    "allow a printable" in {
      import Printable._
      import PrintableInstances._
      import PrintableSyntax._

      format("a") must be("value=a")
      format(123) must be("value=123")
      Cat("michin", 3, "black").format must be("name=michin, age=3, color=black")
    }
  }

  "Semigroupal" must {

    "work on options" in {
      import cats.Semigroupal
      import cats.instances.option._
      import cats.syntax.option._
      Semigroupal[Option].product(1.some, 2.some) must be((1, 2).some)
    }

  }

  "Monoidal" must {

    "work on booleans" in {
      import BooleanMonoidInstances._
      Monoidal(ANDMonoid).combine(true, true) must be(true)
      Monoidal(ORMonoid).combine(false, true) must be(true)
    }

    "work on Monoids for Option" in {
      import cats.instances.int._
      Calculator.add(List(1, 2, 3, 4)) must be(10)

      import cats.instances.option._
      import cats.syntax.option._
      Calculator.add(List(1.some, 2.some, 3.some, 4.some)) must be(10.some)
    }

    "work on Monoids of Order" in {
      val orders = List(
        Order(2.3, 1),
        Order(1.7, 1),
        Order(2.5, 1),
        Order(3.5, 1)
      )
      Calculator.add(orders) must be(Order(10, 4))
    }

    "work on Strings" in {
      import cats.instances.string._
      import cats.syntax.semigroup._

      val stringResult = "Hello" |+| "World" |+| Monoid[String].empty
      stringResult must be("HelloWorld")

    }

  }

}
