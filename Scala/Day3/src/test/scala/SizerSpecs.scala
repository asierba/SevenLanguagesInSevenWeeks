import org.scalatest._

class SizerSpec extends FunSpec with ShouldMatchers {
  // Test drive method to get number of links
  def getNumberOfLinks(c: String): Int = {
    val pattern = "<a"

    var content = c
    var count = 0

    while (content.indexOf(pattern) >= 0) {
      content = content.slice(content.indexOf(pattern) + pattern.length, content.length)
      count = count + 1
    }
    count
  }

  describe("when content is empty") {
    it("should return 0") {
      val content  = ""
      getNumberOfLinks(content) should be (0)
    }
  }

  describe("when content has no link") {
    it("should return 0") {
      val content  = "<html><head></head><body>This is a test</body></html>"
      getNumberOfLinks(content) should be (0)
    }
  }

  describe("when content has a link") {
    it("should return 1") {
      val content  = "<html><head></head><body>This is a test <a href=\"www.example.com\">with a link!</a></body></html>"
      getNumberOfLinks(content) should be (1)
    }
  }

  describe("when content has two links") {
    it("should return 2") {
      val content  = "<html><head></head><body>This is a test <a>with one link!</a> <a>and another</a></body></html>"
      getNumberOfLinks(content) should be (2)
    }
  }

  describe("when content has three links") {
    it("should return 3") {
      val content  = "<html><head></head><body>This is a test <a>with one link!</a> <a>and another</a> <a>and another</a></body></html>"
      getNumberOfLinks(content) should be (3)
    }
  }

}
