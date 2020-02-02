package example

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.must.Matchers

class StateSpec extends AnyWordSpec with Matchers {

  "State" must {

    "Handle the RPN" must {

      import ReversePolishNotation._

      "support simple values" in {
        // TODO 06: make this test pass
        /*evalOne("42").runA(Nil).value must be(42)*/
        fail("WIP")
      }

      "must handle the '+' operator" in {
        // TODO 06: make this test pass
        /*(for {
          _ <- evalOne("1")
          _ <- evalOne("2")
          ans <- evalOne("+")
        } yield ans).runA(Nil).value must be(3)*/
        fail("WIP")
      }

      "must handle the '-' operator" in {
        // TODO 06: make this test pass
        /*(for {
          _ <- evalOne("2")
          _ <- evalOne("1")
          ans <- evalOne("-")
        } yield ans).runA(Nil).value must be(-1)*/
        fail("WIP")
      }

      "must handle the '*' operator" in {
        // TODO 06: make this test pass
        /*(for {
          _ <- evalOne("3")
          _ <- evalOne("5")
          ans <- evalOne("*")
        } yield ans).runA(Nil).value must be(15)*/
        fail("WIP")
      }

      "must handle the '/' operator" in {
        // TODO 06: make this test pass
        /*(for {
          _ <- evalOne("5")
          _ <- evalOne("15")
          ans <- evalOne("/")
        } yield ans).runA(Nil).value must be(3)*/
        fail("WIP")
      }

      "must handle multiple '+'" in {
        // TODO 06: make this test pass
        /*(for {
          _ <- evalOne("1")
          _ <- evalOne("1")
          _ <- evalOne("+")
          _ <- evalOne("1")
          ans <- evalOne("+")
        } yield ans).runA(Nil).value must be(3)*/
        fail("WIP")
      }

      "accumulate multiple values" in {
        // TODO 06: make this test pass
        /*evalAll(List("1", "2", "+", "3", "*")).runA(Nil).value must be(9)*/
        fail("WIP")
      }
    }
  }

}
