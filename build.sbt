name := "scalaSpark"

version := "0.1"

scalaVersion := "2.12.11"

libraryDependencies += "org.apache.spark" %% "spark-core" % "2.4.6"


libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-sql" % "2.4.6"
)


