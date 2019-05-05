import Dependencies._

ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    inThisBuild(commonSettings),
    name := "data-structure",
    libraryDependencies += scalaTest % Test
  )

val commonSettings = List(
  organization      := "com.strikingly",
  organizationName  := "data",
  scalaVersion      := "2.12.6",
  version           := "0.1.0-SNAPSHOT"
)

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
