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
   * TODO 06
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
  def evalOne(sym: String): CalcState[Int] = ???

  /*
   * TODO 06: Fold over the list calling evalOne
   *
   * Your empty element could be calculated like the 'pure state 0':
   * import cats.syntax.applicative._
   * 0.pure[CalcState]
   */
  def evalAll(sym: List[String]): CalcState[Int] = ???

}
