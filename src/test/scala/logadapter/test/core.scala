package logadapter.test:

  object Test extends logadapter.Api.SelfLogging:
    def main(args : Array[String]) : Unit =
      summon[logadapter.LogAdapter].info("Hello")


