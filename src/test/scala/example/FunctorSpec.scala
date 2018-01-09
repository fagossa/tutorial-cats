package example

import example.fixtures.OrderFixture
import org.scalatest.{MustMatchers, WordSpec}

class FunctorSpec extends WordSpec with MustMatchers with OrderFixture {

  import cats.Functor

  "Functor" must {

    "work on Int" in {
      // TODO: add the import for 'list' functors
      import cats.instances.list._
      val list1 = List(1, 2, 3, 4)
      Functor[List].map(list1)(_ + 1) must be(List(2, 3, 4, 5))
    }

    "work on Option" in {
      // TODO: add the import for 'option' functors
      import cats.syntax.option._
      import cats.instances.option._
      Functor[Option].map("toto".some)(_.toUpperCase) must be("TOTO".some)
    }

    "allow lifting" in {
      val func = (x:Int) => x + 1

      // TODO: find a way to 'lift' func to accept Options using a Functor
      import cats.instances.function._
      val lifted = Functor[Option].lift(func)

      import cats.syntax.option._
      lifted(1.some) must be(2.some)
    }

  }

}
