package logadapter.test:

  object Hello:
    def hello[X <: logadapter.LogAdapter](thang : String, api : logadapter.stderr.Api.type) : Unit =
      println( s"------------- hello ${thang} -------------" )
      import api.*
      object HelloObject extends SelfLogging:
        INFO.log(s"Hello ${thang}!")
        INFO.log("goodbye!")
      HelloObject.hashCode()
    def main(args : Array[String]) : Unit =
      hello("stderr", logadapter.stderr.Api)
      //hello("Scribe", logadapter.scribe.Api)
