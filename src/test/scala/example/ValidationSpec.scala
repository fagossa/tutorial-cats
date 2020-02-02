package example

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.must.Matchers

class ValidationSpec extends AnyWordSpec with Matchers {

  "Validation" must {

    import UserValidation._
    import cats.syntax.validated._

    "support valid data" in {
      // TODO 07: make this test pass
      /*val params = Map(
        "name" -> "Terah",
        "age" -> "34"
      )
      validateUser(params) must be(User("Terah", 34).valid[User])*/
      fail("WIP")
    }

    "validate the name" must {

      "handle does not exist name" in {
        /*// TODO 07: make this test pass
        val params = Map(
          "age" -> "34"
        )
        validateUser(params) must be(List("name is not present").invalid[List[String]])*/
        fail("WIP")
      }

      "handle empty name" in {
        // TODO 07: make this test pass
        /*val params = Map(
          "name" -> "",
          "age" -> "34"
        )
        validateUser(params) must be(List("name is blank").invalid[List[String]])*/
        fail("WIP")
      }

    }

    "validate the age" must {

      "handle does not exist age" in {
        /*// TODO 07: make this test pass
        val params = Map(
          "name" -> "Terah"
        )
        validateUser(params) must be(List("age is not present").invalid[List[String]])*/
        fail("WIP")
      }

      "handle empty age" in {
        // TODO 07: make this test pass
        /*val params = Map(
          "name" -> "Terah",
          "age" -> ""
        )
        validateUser(params) must be(List("age is blank").invalid[List[String]])*/
        fail("WIP")
      }

      "handle invalid age" in {
        // TODO 07: make this test pass
        /*val params = Map(
          "name" -> "Terah",
          "age" -> "???"
        )
        validateUser(params) must be(List("age must be an integer").invalid[List[String]])*/
        fail("WIP")
      }

      "handle negative age" in {
        // TODO 07: make this test pass
        /*val params = Map(
          "name" -> "Terah",
          "age" -> "-1"
        )
        validateUser(params) must be(List("Negative value").invalid[List[String]])*/
        fail("WIP")
      }

      "handle multiple errors" in {
        // TODO 07: make this test pass
        /* val params = Map.empty[String, String]
        validateUser(params) must be(List("name is not present", "age is not present").invalid[List[String]])*/
        fail("WIP")
      }

    }
  }

}
