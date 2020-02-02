package example

import org.scalatest.concurrent.ScalaFutures
import org.scalatest.time.{Millis, Seconds, Span}

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.must.Matchers

class WriteAndReadSpec extends AnyWordSpec with Matchers with ScalaFutures {

  implicit val defaultPatience =
    PatienceConfig(timeout = Span(2, Seconds), interval = Span(500, Millis))

  "Write Monad" must {

    "return an Int value" in {
      // TODO 05: make this test pass
      /*NumericOperations.factorial(5).run._2 must be(120)*/
      fail("WIP")
    }

    "return Ints and the different steps of the recursion" in {
      // TODO 05: make this test pass
      /*val eventualVector: Vector[(Vector[String], Int)] = Future
        .sequence(
          Vector(
            Future(NumericOperations.factorial(3).run),
            Future(NumericOperations.factorial(4).run)
          )
        )
        .futureValue

      eventualVector must be(
        Vector(
          (Vector("fact(0)", "fact(1)", "fact(2)", "fact(3)"), 6),
          (Vector("fact(0)", "fact(1)", "fact(2)", "fact(3)", "fact(4)"), 24)
        )
      )*/
    }

  }

}
