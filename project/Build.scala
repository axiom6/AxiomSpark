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

//libraryDependencies += "com.github.scopt" %% "scopt" % "3.3.0"

//resolvers += Resolver.sonatypeRepo("public")

object Version {
  val AxiomSpark      = "0.0.0"
  val Scala           = "2.11.6"
  val Spark           = "1.4.0"
  val SparkCassandra  = "1.3.0-M1"
  val ScalaTest       = "2.2.4"
  val ScalaCheck      = "1.12.2"
  val Cassandra       = "2.1.3"
  val CassandraDriver = "2.1.5"
  val Scopt           = "3.3.0"
 }

object Library {
  import Version._
  val sparkCore         = "org.apache.spark"    %% "spark-core"                         % Spark
  val sparkStreaming    = "org.apache.spark"    %% "spark-streaming"                    % Spark
  val sparkML           = "org.apache.spark"    %% "spark-mllib"                        % Spark  // ApacheV2
  val sparkGraphx       = "org.apache.spark"    %% "spark-graphx"                       % Spark
  val sparkSQL          = "org.apache.spark"    %% "spark-sql"                          % Spark
  val sparkRepl         = "org.apache.spark"    %% "spark-repl"                         % Spark
  val sparkCatalyst     = "org.apache.spark"    %% "spark-catalyst"                     % Spark
  val sparkCassandra    = "com.datastax.spark"  %% "spark-cassandra-connector"          % SparkCassandra // ApacheV2
  val sparkCassandraEmb = "com.datastax.spark"  %% "spark-cassandra-connector-embedded" % SparkCassandra // ApacheV2
  val scopt             = "com.github.scopt"    %% "scopt"                              % Scopt

  val scalaTest      = "org.scalatest"     %% "scalatest"       % Version.ScalaTest  % "test"
  val scalaCheck     = "org.scalacheck"    %% "scalacheck"      % Version.ScalaCheck % "test"
}

object Dependencies {

  import Library._

  val AxiomSpark = Seq( sparkCore, sparkStreaming, sparkML, sparkGraphx,
                        sparkSQL,  sparkCassandra, sparkCassandraEmb,
                        scopt,     scalaTest,      scalaCheck )
}
