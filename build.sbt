scalaVersion := "2.11.8" // no support for 2.10 or 2.12 at the moment

lazy val doobieVersion = "0.3.1-SNAPSHOT"

libraryDependencies ++= Seq(
  "org.tpolecat" %% "doobie-core-cats"       % doobieVersion,
  "org.tpolecat" %% "doobie-postgres-cats" % doobieVersion,
  "org.tpolecat" %% "doobie-contrib-specs2"     % doobieVersion
)

resolvers += 
  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
