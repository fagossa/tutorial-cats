package example

import org.scalatest.{MustMatchers, WordSpec}

class ValidationSpec extends WordSpec with MustMatchers {

  "Validation" must {

    import UserValidation._
    import cats.syntax.validated._

    "support valid data" in {
      // TODO 07: make this test pass
      val params = Map(
        "name" -> "Terah",
        "age" -> "34"
      )
      validateUser(params) must be(User("Terah", 34).valid[User])
    }

    "validate the name" must {

      "handle does not exist name" in {
        // TODO 07: make this test pass
        val params = Map(
          "age" -> "34"
        )
        validateUser(params) must be(List("name is not present").invalid[List[String]])
      }

      "handle empty name" in {
        // TODO 07: make this test pass
        val params = Map(
          "name" -> "",
          "age" -> "34"
        )
        validateUser(params) must be(List("name is blank").invalid[List[String]])
      }

    }

    "validate the age" must {

      "handle does not exist age" in {
        // TODO 07: make this test pass
        val params = Map(
          "name" -> "Terah"
        )
        validateUser(params) must be(List("age is not present").invalid[List[String]])
      }

      "handle empty age" in {
        // TODO 07: make this test pass
        val params = Map(
          "name" -> "Terah",
          "age" -> ""
        )
        validateUser(params) must be(List("age is blank").invalid[List[String]])
      }

      "handle invalid age" in {
        // TODO 07: make this test pass
        val params = Map(
          "name" -> "Terah",
          "age" -> "???"
        )
        validateUser(params) must be(List("age must be an integer").invalid[List[String]])
      }

      "handle negative age" in {
        // TODO 07: make this test pass
        val params = Map(
          "name" -> "Terah",
          "age" -> "-1"
        )
        validateUser(params) must be(List("Negative value").invalid[List[String]])
      }

    }
  }

}
