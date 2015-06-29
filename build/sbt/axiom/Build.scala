import sbt._
//import sbt.Keys._

object Settings {
  val Name = "AxiomSpark"
}

object Resolvers {
  val typesafe =    "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
  val sonatype =    "Sonatype Release"    at "https://oss.sonatype.org/content/repositories/releases"
  val mvnrepository = "MVN Repo"          at "http://mvnrepository.com/artifact"

  val allResolvers = Seq( typesafe, sonatype, mvnrepository )
}

object Version {
  val AxiomSpark = "0.0.0"
  val Scala      = "2.11.6"
  val Spark      = "1.4.0"
  val ScalaTest  = "2.2.4"
  val ScalaCheck = "1.12.2"
 }

object Library {
  val sparkCore      = "org.apache.spark"  %% "spark-core"      % Version.Spark
  val sparkStreaming = "org.apache.spark"  %% "spark-streaming" % Version.Spark
  val sparkGraphx    = "org.apache.spark"  %% "spark-graphx"    % Version.Spark
  val sparkSQL       = "org.apache.spark"  %% "spark-sql"       % Version.Spark
  val sparkRepl      = "org.apache.spark"  %% "spark-repl"      % Version.Spark

  val scalaTest      = "org.scalatest"     %% "scalatest"       % Version.ScalaTest  % "test"
  val scalaCheck     = "org.scalacheck"    %% "scalacheck"      % Version.ScalaCheck % "test"
}

object Dependencies {

  import Library._

  val AxiomSpark = Seq( sparkCore, sparkStreaming, sparkSQL, scalaTest, scalaCheck )
}
