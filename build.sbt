import Dependencies._

ThisBuild / organization := "io.tyoras"
ThisBuild / scalaVersion := "3.2.0"
ThisBuild / version := "0.0.1-SNAPSHOT"

ThisBuild / scalacOptions ++= Seq(
  "-feature",
  "-unchecked",
  //"-Xfatal-warnings", si possible
  "-language:higherKinds",
  "-language:implicitConversions",
  "-encoding",
  "UTF-8"
)

lazy val commonSettings = Seq(
  update / evictionWarningOptions := EvictionWarningOptions.empty,
  assembly / test := {}
)

ThisBuild / coverageMinimumStmtTotal := 75
ThisBuild / coverageFailOnMinimum := false

Global / lintUnusedKeysOnLoad := false


lazy val mergeDependencyUpdate = (project in file("."))
  .settings(
    name := "merge-dependency-update",
    commonSettings,
    packagingSettings,
    libraryDependencies ++= deps ++ testDeps,
    buildInfoKeys := Seq[BuildInfoKey](version),
    buildInfoPackage := "io.tyoras.action",
    buildInfoOptions += BuildInfoOption.BuildTime,
    coverageExcludedPackages := ".*BuildInfo.scala"
  )
  .enablePlugins(JavaAppPackaging, GraalVMNativeImagePlugin, BuildInfoPlugin)

lazy val packagingSettings = Seq(
  Compile / assembly / mainClass := Some("io.tyoras.action.Main"),
  assembly / assemblyJarName := "action.jar",
) ++ graalVMPackagingSettings

//FIXME native image packaging is not working
lazy val graalVMPackagingSettings = Seq(
  graalVMNativeImageOptions ++= Seq(
  )
)
