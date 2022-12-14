package io.tyoras.action

import cats.effect.*

object Main extends IOApp:

  override def run(args: List[String]): IO[ExitCode] = IO.println("hello").as(ExitCode.Success)
