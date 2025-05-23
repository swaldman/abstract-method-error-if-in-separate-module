package logadapter:

  trait AbstractLogAdapter:
    def info( message : String ) : Unit

  trait AbstractApi[T <: AbstractLogAdapter]:
    def logAdapterFor( loggerName : String ) : T
    trait SelfLogging:
      given adapter : T = logAdapterFor(this.getClass.getName)

  object Api extends logadapter.AbstractApi[LogAdapter]:
    def logAdapterFor( loggerName : String ) : LogAdapter = new LogAdapter( loggerName )

  class LogAdapter( loggerName : String ) extends logadapter.AbstractLogAdapter:
    def info( message : String ) : Unit = System.err.println( s"INFO [${loggerName}] ${message}" )

