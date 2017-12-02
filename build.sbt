name := """playAppV1"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "com.netaporter" %% "scala-uri" % "0.4.14",
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test,

  evolutions,
  "org.postgresql"         % "postgresql"                        % "42.1.4"
)
