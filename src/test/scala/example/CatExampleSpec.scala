package example

import example.fixtures.ChatFixture
import org.scalatest.{MustMatchers, WordSpec}

class CatExampleSpec extends WordSpec with MustMatchers with ChatFixture {

  import cats.Monoid

  "Printable" must {
    "allow a printable" in {
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
      import cats.Semigroupal
      import cats.instances.option._
      import cats.syntax.option._
      Semigroupal[Option].product(1.some, 2.some) must be((1, 2).some)
    }

  }

}
