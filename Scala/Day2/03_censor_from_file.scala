import scala.io.Source
import scala.collection.mutable.HashMap

trait Censor {
  val curseWords = loadCurseWordsFromFile("cursewords.csv", ",")

  def loadCurseWordsFromFile(path: String, delimiter: String) : HashMap[String, String] = {
    Source.fromFile(path).getLines()
      .foldLeft(new HashMap[String, String])(
        (words, line) => words += line.split(delimiter)(0) -> line.split(delimiter)(1)
    )
  }

  def getCensored(content: String) : String = {
    curseWords.foldLeft(content)((content, word) => content.replaceAll(word._1, word._2))
  }
}

class Text(c: String) extends  Censor {
  val content = c;

  def print() {
    println("Content: ")
    println(content)
  }

  def printCensoder() {
    println("Censored content: ")
    println(getCensored(content))
  }
}

var text = new Text("You shouldn't be saying words like darn and shoot..")
text.print()
text.printCensoder()

