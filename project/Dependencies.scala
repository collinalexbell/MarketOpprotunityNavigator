import sbt._

object Dependencies {
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.1.1"
  lazy val slick = "com.typesafe.slick" %% "slick" % "3.0.0"
  lazy val slf4j = "org.slf4j" % "slf4j-nop" % "1.6.4"
}
