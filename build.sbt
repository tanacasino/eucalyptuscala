import sbtassembly.Plugin._

name := "eucalyptuscala"

version := "0.1.0"

scalaVersion := "2.11.4"

organization := "com.github.tanacasino"

scalacOptions ++= Seq("-unchecked", "-deprecation")

libraryDependencies ++= {
  Seq(
   "com.github.seratch" %% "awscala"        % "0.4.+"
  )
}

resolvers ++= Seq(
  "snapshots"     at "http://oss.sonatype.org/content/repositories/snapshots",
  "releases"      at "http://oss.sonatype.org/content/repositories/releases"
)

assemblySettings
