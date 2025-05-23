package logadapter:

  enum Level:
    case INFO extends Level
  end Level

  trait LogAdapter:
    inline def info( inline message : =>String ) : Unit

  trait Api[T <: LogAdapter]:

    type LogAdapter = T

    extension ( level : Level )
      inline def log( message : =>String )( using la : T ) : Unit =
        inline level match
          case INFO    => la.info(message)
      end log

    export Level.*

    def classNameToLoggerName( clzName : String ) : String = clzName.reverse.dropWhile( _ == '$' ).map( c => if ( c == '$' ) '.' else c ).reverse

    def logAdapterFor( loggerName : String ) : T
    def logAdapterFor( clz : Class[?] )      : T = logAdapterFor(classNameToLoggerName(clz.getName))
    def logAdapterFor( obj : Any )           : T = logAdapterFor(obj.getClass)

    trait SelfLogging:
      given adapter : T = logAdapterFor(this)
  end Api

