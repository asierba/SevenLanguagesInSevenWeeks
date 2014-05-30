trait Censor {
  val words =  Map("shoot" -> "pucky", "darn" -> "beans")

  def getCensored(content: String) : String = {
    words.foldLeft(content)((content, word) => content.replaceAll(word._1, word._2))
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

