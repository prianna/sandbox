




import sbtassembly.AssemblyPlugin._

scalaVersion := "2.11.8"
//scalaVersion := "2.10.6"

val catsVersion = "0.6.1"
//val sparkversion = "2.0.0"
val sparkversion = "1.6.2"
val doobieVersion = "0.3.0"


spIgnoreProvided := true

val kindProjector = compilerPlugin("org.spire-math" % "kind-projector" % "0.8.0" cross CrossVersion.binary)
val si2712 = compilerPlugin("com.milessabin" % "si2712fix-plugin" % "1.2.0" cross CrossVersion.full)
//val si2712 = compilerPlugin("com.milessabin" % "si2712fix-plugin_2.10.6" % "1.2.0")


libraryDependencies ++= Seq(
  "org.typelevel" %% "cats" % catsVersion,
  "org.tpolecat"   %% "doobie-core"               % doobieVersion,
  "org.tpolecat"   %% "doobie-contrib-postgresql" % doobieVersion,
  "org.tpolecat"   %% "doobie-contrib-specs2"     % doobieVersion,
  "com.fortysevendeg" % "fetch_2.11" % "0.2.0",
  "org.apache.logging.log4j" % "log4j" % "2.6.2",
  "org.scalatest" %% "scalatest" % "3.0.0" % "test",
  kindProjector,
  si2712
)

resolvers ++= Seq(
  "bintray/non" at "http://dl.bintray.com/non/maven",
  "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/",
  "twitter-repo" at "https://maven.twttr.com",
  "Clojars Repository" at "http://clojars.org/repo",
  "Conjars Repository" at "http://conjars.org/repo",
  "Artima Maven Repository" at "http://repo.artima.com/releases",
  "Spark Packages Repo" at "http://dl.bintray.com/spark-packages/maven",
  Opts.resolver.sonatypeSnapshots
)





assemblyMergeStrategy in assembly := {
  case PathList("javax", "servlet", xs @ _*) => MergeStrategy.last
  case PathList("javax", "activation", xs @ _*) => MergeStrategy.last
  case PathList("org", "apache", xs @ _*) => MergeStrategy.last
  case PathList("com", "google", xs @ _*) => MergeStrategy.last
  case PathList("com", "esotericsoftware", xs @ _*) => MergeStrategy.last
  case PathList("com", "codahale", xs @ _*) => MergeStrategy.last
  case PathList("com", "yammer", xs @ _*) => MergeStrategy.last
  case "about.html" => MergeStrategy.rename
  case "META-INF/ECLIPSEF.RSA" => MergeStrategy.last
  case "META-INF/mailcap" => MergeStrategy.last
  case "META-INF/mimetypes.default" => MergeStrategy.last
  case "plugin.properties" => MergeStrategy.last
  case "log4j.properties" => MergeStrategy.last
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}
