
import sbt._
//import sbt.Keys._

object Version {

  val Akka           = "2.3.9"
  val AkkaStreams    = "1.0-RC3"
  val Albebird       = "0.8.1"
  val Bijection      = "0.7.0"
  val Cassandra      = "2.1.3"
  val CassandraDriver = "2.1.5"
  val JDK            = "1.7"
  val JodaConvert    = "1.7"
  val JodaTime       = "2.4"
  val Json4s         = "3.2.10"
  val Kafka          = "0.8.2.1"
  val Kryo           = "3.0.0"
  val Logback        = "1.0.13"
  val Scala          = "2.10.5"// waiting for spark-streaming-kafka to be supported in scala 2.11
  val Pickling       = "0.10.1"
  val ScalaTest      = "2.2.2"
  val Scalaz         = "7.1.0"
  val ScalazContrib  = "0.1.5"
  val ScalazStream   = "0.1"
  val Sigar          = "1.6.4"
  val Slf4j          = "1.6.1"
  val Spark          = "1.3.1"
  val SparkCassandra = "1.3.0-M1"
}

object Library {
  import Version._

  val akkaStream        = "com.typesafe.akka"   %% "akka-stream-experimental"           % AkkaStreams
  val akkaHttpCore      = "com.typesafe.akka"   %% "akka-http-core-experimental"        % AkkaStreams
  val akkaActor         = "com.typesafe.akka"   %% "akka-actor"                         % Akka
  val akkaCluster       = "com.typesafe.akka"   %% "akka-cluster"                       % Akka
  val akkaRemote        = "com.typesafe.akka"   %% "akka-remote"                        % Akka
  val akkaSlf4j         = "com.typesafe.akka"   %% "akka-slf4j"                         % Akka
  val algebird          = "com.twitter"         %% "algebird-core"                      % Albebird
  val bijection         = "com.twitter"         %% "bijection-core"                     % Bijection
  val driver            = "com.datastax.cassandra" % "cassandra-driver-core"            % CassandraDriver driverExclusions
  val jodaTime          = "joda-time"           % "joda-time"                           % JodaTime   % "compile;runtime" // ApacheV2
  val jodaConvert       = "org.joda"            % "joda-convert"                        % JodaConvert % "compile;runtime" // ApacheV2
  val json4sCore        = "org.json4s"          %% "json4s-core"                        % Json4s          // ApacheV2
  val json4sJackson     = "org.json4s"          %% "json4s-jackson"                     % Json4s          // ApacheV2
  val json4sNative      = "org.json4s"          %% "json4s-native"                      % Json4s          // ApacheV2
  val kafka             = "org.apache.kafka"    %% "kafka"                              % Kafka kafkaExclusions // ApacheV2
  val kafkaStreaming    = "org.apache.spark"    %% "spark-streaming-kafka"              % Spark sparkExclusions // ApacheV2
  val logback           = "ch.qos.logback"      % "logback-classic"                     % Logback
  val scalazContrib     = "org.typelevel"       %% "scalaz-contrib-210"                 % ScalazContrib   // MIT
  val scalazContribVal  = "org.typelevel"       %% "scalaz-contrib-validation"          % ScalazContrib   // MIT
  val pickling          = "org.scala-lang.modules" %% "scala-pickling"                  % Pickling
  val scalazStream      = "org.scalaz.stream"   %% "scalaz-stream"                      % ScalazStream    // MIT
  val slf4jApi          = "org.slf4j"           % "slf4j-api"                           % Slf4j           // MIT
  val sparkML           = "org.apache.spark"    %% "spark-mllib"                        % Spark sparkExclusions // ApacheV2
  val sparkCatalyst     = "org.apache.spark"    %% "spark-catalyst"                     % Spark sparkExclusions
  val sparkCassandra    = "com.datastax.spark"  %% "spark-cassandra-connector"          % SparkCassandra // ApacheV2
  val sparkCassandraEmb = "com.datastax.spark"  %% "spark-cassandra-connector-embedded" % SparkCassandra embeddedExclusions // ApacheV2
  val sigar             = "org.fusesource"      % "sigar"                               % Sigar
}

object Dependencies {
  import Library._

  val akka = Seq(akkaStream, akkaHttpCore, akkaActor, akkaCluster, akkaRemote, akkaSlf4j)

  val connector = Seq(driver, sparkCassandra, sparkCatalyst, sparkCassandraEmb)

  val json = Seq(json4sCore, json4sJackson, json4sNative)

  val logging = Seq(logback, slf4jApi)

  val scalaz = Seq(scalazContrib, scalazContribVal, scalazStream)

  val time = Seq(jodaConvert, jodaTime)

  val test = Seq(Test.akkaTestKit, Test.scalatest)

  /** Module deps */
  val client = akka ++ logging ++ scalaz ++ Seq(pickling, sparkCassandraEmb, sigar)

  val core = akka ++ logging ++ time

  val app = connector ++ json ++ scalaz ++ test ++
    Seq(algebird, bijection, kafka, kafkaStreaming, pickling, sparkML, sigar)

  val examples = connector ++ time ++ json ++
    Seq(kafka, kafkaStreaming, sparkML, "org.slf4j" % "slf4j-log4j12" % "1.6.1")
}