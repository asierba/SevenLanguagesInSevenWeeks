import org.scalatest._

class TicTacToe extends FunSpec with ShouldMatchers {

  def getWinner(board : Array[Array[Char]]) : Char = {
    if(board(0).forall(x => x == board(0)(0))) {
      return board(0)(0)
    }

    return ' '
  }

  describe("when the board is empty") {
    it("there should be no winner") {
      val board = Array(
		    Array(' ', ' ', ' '),
		    Array(' ', ' ', ' '),
		    Array(' ', ' ', ' '))

      	getWinner(board) should be (' ')
    }
  }

  describe("when the game is not over yet") {
    it("there should be no winner") {
      val board = Array(
        Array('X', 'O', 'X'),
        Array(' ', 'O', ' '),
        Array(' ', 'X', 'O'))

        getWinner(board) should be (' ')
    }
  }

  describe("when the game is not over yet v2") {
    it("there should be no winner") {
      val board = Array(
        Array(' ', 'X', 'X'),
        Array(' ', ' ', ' '),
        Array(' ', ' ', ' '))

        getWinner(board) should be (' ')
    }
  }

  describe("when the board is empty v3") {
    it("there should be no winner") {
      val board = Array(
        Array('X', 'X', ' '),
        Array(' ', ' ', ' '),
        Array(' ', ' ', ' '))

        getWinner(board) should be (' ')
    }
  }

  describe("when X makes three in a row") {
    it("X should be the winner") {
      val board = Array(
        Array('X', 'X', 'X'),
        Array(' ', 'O', ' '),
        Array(' ', 'O', 'O'))

        getWinner(board) should be ('X')
    }
  }

  describe("when O makes three in a row") {
    it("O should be the winner") {
      val board = Array(
        Array('O', 'O', 'O'),
        Array(' ', 'X', ' '),
        Array(' ', 'X', 'X'))

        getWinner(board) should be ('O')
    }
  }

}
