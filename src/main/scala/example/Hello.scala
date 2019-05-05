package example

object Hello extends Greeting with App {
  for (i <- 0 to 4) {
    println(greeting)
  }
}

trait Greeting {
  lazy val greeting: String = "hello"
}
