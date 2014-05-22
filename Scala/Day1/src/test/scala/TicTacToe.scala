import org.scalatest._

class TicTacToe extends FunSpec with ShouldMatchers {

  def getWinner(x : Array[Array[Char]]) = {
    ' '
  }

  describe("In an empty board") {
    it("there should be no winner") {
      val board = Array(
		    Array(' ', ' ', ' '),
		    Array(' ', ' ', ' '),
		    Array(' ', ' ', ' '))

      	getWinner(board) should be (' ')
    }
  }
}
