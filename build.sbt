import play.sbt.PlayScala

ThisBuild / name := "play-rest-api"
ThisBuild / organization := "ru.mikhaildruzhinin"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.13.11"

resolvers += "Secured Central Repository" at "https://repo.maven.apache.org/maven2"

externalResolvers := Resolver.combineDefaultResolvers(resolvers.value.toVector, mavenCentral = false)

// this one is redundant as the PlayScala plugin already brings it, but showing here for completeness
val playFramework = "com.typesafe.play" %% "play" % "2.8.20"
val macwire = "com.softwaremill.macwire" %% "macros" % "2.5.8" % "provided"

lazy val root = (project in file("."))
  .settings(
    name := "rest-play-api",
    libraryDependencies ++= Seq(playFramework, macwire)
  ).enablePlugins(PlayScala)
