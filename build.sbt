import Dependencies._

name := "ESClient"
version := "0.1"
scalaVersion := "2.12.7"

lazy val ES = (project in file("."))
 .settings(
   name := "ESClient",
  libraryDependencies ++= Seq(esDependency,slf4j,akkaslf4j,slfdep,scalatest,snake,scalalogg) ++ bean
 )
