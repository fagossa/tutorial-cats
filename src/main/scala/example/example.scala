package object example {

  def mustBeEqual[A](p1: A, p2: A): Unit = {
    if (p1 != p2) {
      throw new IllegalArgumentException(s"<$p1> was not equal to <$p2>")
    } else {
      println(s"comparing <$p1> and <$p2>")
    }
  }

}
