import scala.io._
import scala.actors._
import Actor._
import scala.collection.Seq

object PageLoader {
  def getPageSize(url : String) = Source.fromURL(url).mkString.length
  def getNumberOfLinks(url : String) = {
    val pattern = "<a"

    var content = Source.fromURL(url).mkString
    var count = 0

    while(content.indexOf(pattern) >= 0) {
      content = content.slice(content.indexOf(pattern) + pattern.length, content.length)
      count = count + 1
    }
    count
  }
}

val urls = List("http://www.amazon.com/",
               "http://www.twitter.com/",
               "http://www.google.com/",
               "http://www.cnn.com/" )

// START:time
def timeMethod(method: () => Unit) = {
val start = System.nanoTime
method()
val end = System.nanoTime
println("Method took " + (end - start)/1000000000.0 + " seconds.")
}
// END:time

// START:sequential
def getPageSizeSequentially() = {
for(url <- urls) {
   println("Size for " + url + ": " + PageLoader.getPageSize(url))
}
}
// END:sequential

// START:concurrent
def getPageSizeConcurrently() = {
val caller = self

for(url <- urls) {
   actor { caller ! (url, PageLoader.getPageSize(url), PageLoader.getNumberOfLinks(url)) }
}

for(i <- 1 to urls.size) {
   receive {
     case (url, size, linksNumber) =>
       println("Size for " + url + ": " + size + " Links: " + linksNumber)
   }
}
}
// END:concurrent

// START:script
println("Sequential run:")
timeMethod { getPageSizeSequentially }

println("Concurrent run")
timeMethod { getPageSizeConcurrently }
// END:script