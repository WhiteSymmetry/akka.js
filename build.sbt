import ScalaJSKeys._

val commonSettings = Seq(
    organization := "org.scalajs",
    version := "0.1-SNAPSHOT",
    normalizedName ~= { _.replace("scala-js", "scalajs") },
    scalacOptions ++= Seq(
        "-deprecation",
        "-unchecked",
        "-feature",
        "-encoding", "utf8"
    )
)

lazy val root = project.in(file(".")).settings(commonSettings: _*)
  .aggregate(spickling, actors)

lazy val spickling = project.settings(commonSettings: _*)

lazy val actors = project.settings(commonSettings: _*)
  .dependsOn(spickling)
