package logadapter.stderr:

  import java.time.*, format.DateTimeFormatter

  object Api extends logadapter.Api[LogAdapter]:
    def logAdapterFor( loggerName : String ) : LogAdapter = new LogAdapter( loggerName )
  end Api

  object LogAdapter:
    val TimestampFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'@'HH':'mm':'ss")

  class LogAdapter( loggerName : String ) extends logadapter.LogAdapter:

    private inline def log( inline tag : String, inline message : =>String ) : Unit =
      val timestamp = LogAdapter.TimestampFormatter.format( LocalDateTime.now )
      System.err.println( s"${timestamp} ${tag} [${loggerName}] ${message}" )

    inline def info( inline message : =>String ) : Unit = log("INFO",    message)
  end LogAdapter
