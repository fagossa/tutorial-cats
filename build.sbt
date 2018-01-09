import Dependencies._

shellPrompt := { state =>
  s"[${name.value}] > "
}

lazy val root = (project in file("."))
  .settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.4",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Tutorial cats",
    licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))
  )
  .settings(
    libraryDependencies ++= List(
      cats_core,
      scalaTest % Test
    )
  )
  .settings(
    fork in run := true,
    fmtSettings,
    scalacOptions ++= scalaCSettings
  )

lazy val fmtSettings =
  Seq(
    scalafmtOnCompile := true,
    scalafmtOnCompile.in(Sbt) := false,
    scalafmtVersion := "1.3.0"
  )

lazy val scalaCSettings =
  Seq(
    "-unchecked",
    "-deprecation",
    "-language:_",
    "-target:jvm-1.8",
    "-encoding", "UTF-8",
    "-Xfatal-warnings",
    "-Ywarn-infer-any",
    "-Ypartial-unification"
  )
