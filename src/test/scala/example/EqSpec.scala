package example

import example.fixtures.GatoFixture
import org.scalatest.{MustMatchers, WordSpec}

class EqSpec extends WordSpec with MustMatchers with GatoFixture {
  import cats.syntax.eq._
  import EqSpecOps._

  "Eq" must {

    "work on Ints" in {
      // TODO 01: find the right import
      import cats.Eq
      import cats.instances.int._

      val eqInt = Eq[Int]
      eqInt.eqv(123, 123) `must be` true
      eqInt.eqv(123, 321) `must be` false

      (123 =!= 321) `must be` true
    }

    "work on Options" in {
      // TODO 01: find the right import
      import cats.instances.option._
      // comparing options
      (Option(123) === Option(123)) `must be` true

      import cats.syntax.option._
      (123.some === 123.some) `must be` true
    }

    "work on Gatos" in {
      import cats.syntax.option._

      import cats.Eq
      // TODO 01: Equality should work between cats
      Eq[Gato].eqv(cat1, cat2) `must be` false
      (cat1.some === none[Gato]) `must be` false

      Gato.isEqual(cat1, cat2) `must be` false
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
