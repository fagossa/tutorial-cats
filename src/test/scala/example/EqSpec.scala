package example

import example.fixtures.GatoFixture
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.must.Matchers

class EqSpec extends AnyWordSpec with Matchers with GatoFixture {
  import cats.syntax.eq._
  import EqSpecOps._

  "Eq" must {

    "work on Ints" in {
      // TODO 01: find the right import
      /*val eqInt = Eq[Int]
      eqInt.eqv(123, 123) `must be` (true)
      eqInt.eqv(123, 321) `must be` (false)

      (123 =!= 321) `must be` (true)*/
      fail("WIP")
    }

    "work on Options" in {
      // TODO 01: find the right import
      /*
      // comparing options
      (Option(123) === Option(123)) `must be` (true)

      (123.some === 123.some) `must be` (true)
       */
      fail("WIP")
    }

    "work on Gatos" in {
      // TODO 01: Equality should work between gatos
      /*
      Eq[Gato].eqv(cat1, cat2) `must be` (false)
      (cat1.some === none[Gato]) `must be` (false)

      Gato.isEqual(cat1, cat2) `must be` (false)
       */
      fail("WIP")
    }

  }

}

object EqSpecOps {

  implicit class BooleanOps(a: Boolean) {
    def `must be`(b: Boolean): Unit = {
      if (a != b) throw new IllegalArgumentException(s"$a is not equal to $b")
    }
  }
}
