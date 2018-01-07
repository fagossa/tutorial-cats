package example

import example.fixtures.ChatFixture
import org.scalatest.{MustMatchers, WordSpec}

class EqSpec extends WordSpec with MustMatchers with ChatFixture {
  import cats.syntax.eq._
  import EqSpecOps._

  "Eq" must {

    "work on Ints" in {
      import cats.Eq
      import cats.instances.int._

      val eqInt = Eq[Int]
      eqInt.eqv(123, 123) must_be (true)
      eqInt.eqv(123, 321) must_be (false)

      //(123 === 123) must_be (true) // Clash with scalatest :(
      (123 =!= 321) must_be (true)
    }

    "work on Options" in {
      import cats.instances.option._
      // comparing options
      (Option(123) === Option(123)) must_be (true)

      import cats.syntax.option._
      (123.some === 123.some) must_be (true)
      // (123.some =!= 321.some) must_be (true) // Clash with scalatest :(
      // (123.some =!= none[Int]) must_be (true) // Clash with scalatest :(
      // (Option(123) =!= Option.empty[Int]) must_be (true) // Clash with scalatest :(
    }

    "work on Cats" in {
      import cats.syntax.option._

      import cats.Eq
      Eq[Chat].eqv(cat1, cat2) must_be (false)
      (cat1.some === none[Chat]) must_be (false)

      Chat.isEqual(cat1, cat2) must_be (false)
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
