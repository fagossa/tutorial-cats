import Dependencies._

lazy val root = (project in file("."))
  .settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.4",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Tutorial cats",
    libraryDependencies ++= List(
      cats_core,
      scalaTest % Test
    )
  )
  .settings(
      scalacOptions += "-Ypartial-unification"
  )
