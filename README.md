# Dotty bug? 

## AbstractMethodError, but only if the application is compiled separately from library

Please see the this Scala/Dotty issue. 

This issue appears under Scala 3.3.6 and 3.7.0, with `mill` as well as `sbt`.

This repository is an `sbt` project. It compiles just fine, but if you try to run the test program...

```plaintext
> Test / run
```

an `AbstractMethodError` results:

```plaintext
[info] compiling 2 Scala sources to /Users/swaldman/Documents/BaseFolders/development/playpen/inheritance-of-nested-traits-sbt/target/scala-3.3.6/classes ...
[info] compiling 1 Scala source to /Users/swaldman/Documents/BaseFolders/development/playpen/inheritance-of-nested-traits-sbt/target/scala-3.3.6/test-classes ...
[info] running logadapter.test.Hello 
------------- hello stderr -------------
Exception in thread "sbt-bg-threads-1" java.lang.AbstractMethodError: Receiver class logadapter.test.Hello$HelloObject$2$ does not define or inherit an implementation of the resolved method 'abstract logadapter.Api logadapter$Api$SelfLogging$$$outer()' of interface logadapter.Api$SelfLogging.
	at logadapter.Api$SelfLogging.adapter(core.scala:29)
	at logadapter.Api$SelfLogging.adapter$(core.scala:28)
	at logadapter.test.Hello$HelloObject$2$.adapter$lzyINIT1(core.scala:7)
	at logadapter.test.Hello$HelloObject$2$.adapter(core.scala:7)
	at logadapter.test.Hello$HelloObject$2$.<init>(core.scala:8)
	at logadapter.test.Hello$.HelloObject$lzyINIT1$1(core.scala:7)
	at logadapter.test.Hello$.HelloObject$1(core.scala:7)
	at logadapter.test.Hello$.hello(core.scala:10)
	at logadapter.test.Hello$.main(core.scala:12)
	at logadapter.test.Hello.main(core.scala)
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at sbt.Run.invokeMain(Run.scala:135)
	at sbt.Run.execute$1(Run.scala:85)
	at sbt.Run.$anonfun$runWithLoader$5(Run.scala:112)
	at sbt.Run$.executeSuccess(Run.scala:178)
	at sbt.Run.runWithLoader(Run.scala:112)
	at sbt.Defaults$.$anonfun$bgRunTask$6(Defaults.scala:2072)
	at sbt.Defaults$.$anonfun$termWrapper$2(Defaults.scala:2011)
	at scala.runtime.java8.JFunction0$mcV$sp.apply(JFunction0$mcV$sp.java:23)
	at scala.util.Try$.apply(Try.scala:213)
	at sbt.internal.BackgroundThreadPool$BackgroundRunnable.run(DefaultBackgroundJobService.scala:378)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
	at java.base/java.lang.Thread.run(Thread.java:1583)
[success] Total time: 2 s, completed May 22, 2025, 10:11:23 PM
```
