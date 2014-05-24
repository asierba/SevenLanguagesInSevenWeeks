import org.scalatest._

class TicTacToe extends FunSpec with ShouldMatchers {

  def getWinner(board : Array[Array[Char]]) : Char = {
    val winner = threeInARow(board)

    if(winner != ' ')
      return winner

    return threeInARow(board.transpose)
  }

  def threeInARow(board : Array[Array[Char]]) : Char = {
    for(row <- board) {
      if(row.forall(x => x == row.head)) {
       return row.head
      }
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

  describe("when just two X are in a row right side") {
    it("there should be no winner") {
      val board = Array(
        Array(' ', 'X', 'X'),
        Array(' ', ' ', ' '),
        Array(' ', ' ', ' '))

      getWinner(board) should be (' ')
    }
  }

  describe("when just two X are in a row left side") {
    it("there should be no winner") {
      val board = Array(
        Array('X', 'X', ' '),
        Array(' ', ' ', ' '),
        Array(' ', ' ', ' '))

      getWinner(board) should be (' ')
    }
  }

  describe("when three X are in the first row") {
    it("X should be the winner") {
      val board = Array(
        Array('X', 'X', 'X'),
        Array(' ', 'O', ' '),
        Array(' ', 'O', 'O'))

      getWinner(board) should be ('X')
    }
  }

  describe("when three X are in the second row") {
    it("X should be the winner") {
      val board = Array(       
        Array(' ', 'O', ' '),
        Array('X', 'X', 'X'),
        Array(' ', 'O', 'O'))

      getWinner(board) should be ('X')
    }
  }

  describe("when three X are in the last row") {
    it("X should be the winner") {
      val board = Array(       
        Array(' ', 'O', ' '),
        Array(' ', 'O', 'O'),
        Array('X', 'X', 'X'))

      getWinner(board) should be ('X')
    }
  }

  describe("when three O in a row") {
    it("O should be the winner") {
      val board = Array(
        Array('O', 'O', 'O'),
        Array(' ', 'X', ' '),
        Array(' ', 'X', 'X'))

      getWinner(board) should be ('O')
    }
  }

  describe("when three X are in the first column") {
    it("X should be the winner") {
      val board = Array(
        Array('X', 'O', ' '),
        Array('X', ' ', ' '),
        Array('X', 'O', 'O'))

      getWinner(board) should be ('X')
    }
  }
  describe("when three X are in the second column") {
    it("X should be the winner") {
      val board = Array(
        Array('O', 'X', ' '),
        Array(' ', 'X', ' '),
        Array('O', 'X', 'O'))

      getWinner(board) should be ('X')
    }
  }
}
