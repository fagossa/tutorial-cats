package example

import example.fixtures.GatoFixture
import org.scalatest.{MustMatchers, WordSpec}

class EqSpec extends WordSpec with MustMatchers with GatoFixture {
  import cats.syntax.eq._
  import EqSpecOps._

  "Eq" must {

    "work on Ints" in {
      // TODO 01: find the right import
      /*
      val eqInt = Eq[Int]
      eqInt.eqv(123, 123) must_be (true)
      eqInt.eqv(123, 321) must_be (false)

      (123 =!= 321) must_be (true)
       */
      fail("WIP")
    }

    "work on Options" in {
      // TODO 01: find the right import
      /*
      // comparing options
      (Option(123) === Option(123)) must_be (true)

      (123.some === 123.some) must_be (true)
       */
      fail("WIP")
    }

    "work on Gatos" in {
      // TODO 01: Equality should work between gatos
      /*
      Eq[Gato].eqv(cat1, cat2) must_be (false)
      (cat1.some === none[Gato]) must_be (false)

      Gato.isEqual(cat1, cat2) must_be (false)
       */
      fail("WIP")
    }

  }

}

object EqSpecOps {

  implicit class BooleanOps(a: Boolean) {
    def must_be(b: Boolean): Unit = {
      if (a != b) throw new IllegalArgumentException(s"$a is not equal to $b")
    }
  }
}
