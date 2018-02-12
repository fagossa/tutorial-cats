package example

import example.Printable.format
import example.fixtures.GatoFixture
import org.scalatest.{MustMatchers, WordSpec}

class PrintableSpec extends WordSpec with MustMatchers with GatoFixture {

  "Printable" must {

    "handle Int" in {
      // TODO 02: Define the mandatory type class to make this work
      import PrintableInstances._
      //format(123) must be("value=123")
      fail("WIP")
    }

    "handle String" in {
      // TODO 02: Define the mandatory type class to make this work
      import PrintableInstances._
      //format("a") must be("value=a")
      fail("WIP")
    }

    "allow a printable" in {
      // TODO 02: import the Printable objects to make this work
      import PrintableInstances._
      import PrintableSyntax._

      //michin.format must be("name=michin, age=3, color=black")
      fail("WIP")
    }
  }

}
