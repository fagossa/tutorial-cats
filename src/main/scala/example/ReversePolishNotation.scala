package example

object ReversePolishNotation {

  import cats.data.State

  /*
   * You can think of State monad of something like this:
   *
   * type State[S, A] = S => (S, A)
   *
   * For example, you can create instances of state with the following structure:
   *
   * val s = State[String, String] { originalString =>
   *   (originalString, originalString.toUpperCase)
   * }
   * s.runA("hello").value === "HELLO"
   *
   * */

  type CalcState[A] = State[List[Int], A]

  /*
   * This function must support the symbols {+,-,*,/}
   *
   * If the symbol is a number
   *   stack-it
   * otherwise
   *   pop the last two symbols
   *   execute the operation
   *   stack the result
   *
   * Note: for simplicity do not implement any error handling!
   *
   */
  def evalOne(sym: String): CalcState[Int] = {
    sym match {
      case "+" => operator { case (a, b) => a + b }
      case "-" => operator { case (a, b) => a - b }
      case "*" => operator { case (a, b) => a * b }
      case "/" => operator { case (a, b) => a / b }
      case num => operand(num.toInt)
    }
  }

  private def operator(f: (Int, Int) => Int): CalcState[Int] =
    State[List[Int], Int] {
      case fn :: sn :: tail =>
        val ans = f(fn, sn)
        (ans :: tail, ans)
      case _ =>
        sys.error("Fail!")
    }

  private def operand(i: Int): CalcState[Int] = {
    State[List[Int], Int] { e =>
      (i :: e, i)
    }
  }

  /*
   * Fold over the list calling evalOne
   *
   * Your empty element could be calculated like this:
   * import cats.syntax.applicative._
   * 0.pure[CalcState]
   */
  def evalAll(sym: List[String]): CalcState[Int] = {
    import cats.syntax.applicative._
    sym.foldLeft(0.pure[CalcState]) {
      case (a, b) =>
        a.flatMap(_ => evalOne(b))
    }
  }
}
