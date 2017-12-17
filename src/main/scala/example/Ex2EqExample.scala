package example

object EqExample extends App {
  import cats.Eq

  // comparing ints
  import cats.instances.int._
  val eqInt = Eq[Int]
  mustBeEqual(eqInt.eqv(123, 123), true)
  mustBeEqual(eqInt.eqv(123, 321), false)

  import cats.syntax.eq._
  mustBeEqual(123 === 123, true)
  mustBeEqual(123 =!= 321, true)

  // comparing options
  import cats.instances.option._
  mustBeEqual(Option(123) === Option(123), true)
  mustBeEqual(Option(123) =!= Option.empty[Int], true)

  import cats.syntax.option._
  mustBeEqual(123.some === 123.some, true)
  mustBeEqual(123.some =!= 321.some, true)
  mustBeEqual(123.some =!= none[Int], true)

  val cat1 = Cat("Garfield",   38, "orange and black")
  val cat2 = Cat("Heathcliff", 33, "orange and black")
  mustBeEqual(cat1 === cat2, false)
  mustBeEqual(cat1.some === none[Cat], false)
}
