import sbt._

object Dependencies {

  case object ch {
    case object qos {
      case object logback {
        val `logback-classic` = "ch.qos.logback" % "logback-classic" % "1.4.5"
      }
    }
  }

  case object com {
    case object monovore {
      val declineVersion = "2.4.0"
      val decline = "com.monovore" %% "decline"                 % declineVersion
      val `decline-effect` = "com.monovore" %% "decline-effect" % declineVersion
    }
  }

  case object io {
    case object circe {
      val circeVersion = "0.14.1"
      val `circe-core` = dep("core")
      val `circe-generic` = dep("generic")
      private def dep(artifact: String): ModuleID = "io.circe" %% s"circe-$artifact" % circeVersion
    }
  }

  case object org {

    case object http4s {
      val http4sVersion = "0.23.11"
      val `http4s-blaze-server` = dep("blaze-server")
      val `http4s-circe` = dep("circe")
      val `http4s-dsl` = dep("dsl")

      private def dep(artifact: String): ModuleID = "org.http4s" %% s"http4s-$artifact" % http4sVersion
    }

    case object scalacheck {
      val scalacheck = "org.scalacheck" %% "scalacheck" % "1.17.0"
    }

    case object scalatest {
      val scalatest = "org.scalatest" %% "scalatest" % "3.2.14"
    }

    case object scalatestplus {
      val `scalacheck-1-15` = "org.scalatestplus" %% "scalacheck-1-17" % "3.2.14.0"
    }

    case object typelevel {
      val `cats-core` = "org.typelevel" %% "cats-core"           % "2.9.0"
      val `cats-effect` = "org.typelevel" %% "cats-effect"       % "3.4.2"
      val `kind-projector` = "org.typelevel" %% "kind-projector" % "0.13.0" cross CrossVersion.full
      val `log4cats-slf4j` = "org.typelevel" %% "log4cats-slf4j" % "2.5.0"
    }
  }

  lazy val deps = Seq(
    ch.qos.logback.`logback-classic`,
    com.monovore.decline,
    com.monovore.`decline-effect`,
    org.typelevel.`cats-core`,
    org.typelevel.`cats-effect`,
    org.typelevel.`log4cats-slf4j`
  )

  lazy val testDeps = Seq(
    org.scalacheck.scalacheck,
    org.scalatest.scalatest
  ).map(_ % Test)
}
