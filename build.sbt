ThisBuild / version := "0.1.0"
ThisBuild / organization := "dev.argon"
ThisBuild / organizationName := "Argon"
ThisBuild / organizationHomepage := Some(url("https://github.com/argon-lang"))
ThisBuild / homepage := Some(url("https://github.com/argon-lang/sbt-npmutil"))
ThisBuild / licenses := Seq("Apache 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))

ThisBuild / scmInfo := Some(
    ScmInfo(
        url("https://github.com/argon-lang/verilization"),
        "scm:git@github.com:argon-lang/verilization"
    )
)

ThisBuild / developers := List(
    Developer(
        id = "argon-dev",
        name = "argon-dev",
        email = "argon@argon.dev",
        url = url("https://github.com/argon-dev"),
    )
)


addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.8.0")

val circeVersion = "0.14.1"

lazy val root = (project in file("."))
  .enablePlugins(SbtPlugin)
  .settings(
    name := "sbt-npmutil",
    description := "NPM Util SBT Plugin",
    
    pluginCrossBuild / sbtVersion := {
      scalaBinaryVersion.value match {
        case "2.12" => "1.2.8"
      }
    },

    libraryDependencies ++= Seq(
      "io.circe" %% "circe-core" % circeVersion,
      "io.circe" %% "circe-generic" % circeVersion,
      "io.circe" %% "circe-parser" % circeVersion,
    ),

  )