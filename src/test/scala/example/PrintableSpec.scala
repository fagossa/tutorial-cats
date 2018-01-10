package example

import example.fixtures.ChatFixture
import org.scalatest.{MustMatchers, WordSpec}

class PrintableSpec extends WordSpec with MustMatchers with ChatFixture {

  "Printable" must {
    "allow a printable" in {
      // TODO 02: import the Printable objects to make this work
      import Printable._
      import PrintableInstances._
      import PrintableSyntax._

      format("a") must be("value=a")
      format(123) must be("value=123")
      michin.format must be("name=michin, age=3, color=black")
    }
  }

  "Semigroupal" must {

    "work on options" in {
      // TODO 02: ???
      import cats.Semigroupal
      import cats.instances.option._
      import cats.syntax.option._
      Semigroupal[Option].product(1.some, 2.some) must be((1, 2).some)
    }

  }

}
