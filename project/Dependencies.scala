import sbt._

object Dependencies {
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.1.0"
  //lazy val scalaTest = "com.ironcorelabs" %% "cats-scalatest" % "2.3.0" % "test"
  lazy val cats_core = "org.typelevel" %% "cats-core" % "2.1.0"
}
