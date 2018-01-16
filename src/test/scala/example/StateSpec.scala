package example

import org.scalatest.{MustMatchers, WordSpec}

class StateSpec extends WordSpec with MustMatchers {

  "State" must {

    "Handle the RPN" must {

      import ReversePolishNotation._

      "support simple values" in {
        // TODO 06: implement this function
        evalOne("42").runA(Nil).value must be(42)
      }

      "must handle the '+' operator" in {
        // TODO 06: implement this function
        (for {
          _ <- evalOne("1")
          _ <- evalOne("2")
          ans <- evalOne("+")
        } yield ans).runA(Nil).value must be(3)
      }

      "must handle the '*' operator" in {
        // TODO 06: implement this function
        (for {
          _ <- evalOne("3")
          _ <- evalOne("5")
          ans <- evalOne("*")
        } yield ans).runA(Nil).value must be(15)
      }

      "accumulate multiple values" in {
        // TODO 06: implement this function
        evalAll(List("1", "2", "+", "3", "*")).runA(Nil).value must be(9)
      }
    }
  }

}
