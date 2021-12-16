import sbt._
object Dependencies {

  lazy val esDependency = "com.sksamuel.elastic4s" %% "elastic4s-client-esjava" % "7.8.1"
  lazy val slf4j = "org.slf4j"                 % "slf4j-api"         % "1.7.5"
  lazy val akkaslf4j = "com.typesafe.akka"         %% "akka-slf4j"       % "2.4.14"
  lazy val slfdep = "ch.qos.logback" % "logback-classic" % "1.1.3" % Runtime
  lazy val scalatest = "org.scalatest" %% "scalatest" % "3.0.0" % "test"
  //lazy val logg = Seq(
  //  "org.apache.logging.log4j" %% "log4j-api-scala" % "12.0",
  //  "org.apache.logging.log4j" % "log4j-core" % "2.13.0" % Runtime
 // )

  lazy val snake = "org.yaml" % "snakeyaml" % "1.16"

  lazy val bean = Seq(
    "org.scala-lang" % "scala-reflect" % "2.12.7",
    "org.scala-lang" % "scala-compiler" % "2.10.3"
  )

  lazy val scalalogg = "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0"


}