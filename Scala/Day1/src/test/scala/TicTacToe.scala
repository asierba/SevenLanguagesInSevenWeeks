import org.scalatest._

class TicTacToe extends FunSpec with ShouldMatchers {

  object Player extends Enumeration {
    type Player = Value
    val NONE = Value(' ')
    val X = Value('X')
    val O = Value('O')
  }

  import Player._

  def getWinner(board : Array[Array[Player]]) : Player = {
    var winner = getWinnerInRows(board)

    if(winner != Player.NONE)
      return winner

    winner = getWinnerInColumns(board)

    if(winner != Player.NONE)
      return winner

    return getWinnerInDiagonals(board)
  }

  def getWinnerInRows(board : Array[Array[Player]]) : Player = {
    for(row <- board) {
      if(row.forall(x => x == row.head)) {
       return row.head
      }
    }

    return Player.NONE
  }

  def getWinnerInColumns(board : Array[Array[Player]]) : Player = {
    return getWinnerInRows(board.transpose)
  }

  def getWinnerInDiagonals(board : Array[Array[Player]]) : Player =  {
    if (board(0)(0) == board(1)(1) && board(2)(2) == board(1)(1))
      return board(1)(1)

    if (board(2)(0) == board(1)(1) && board(0)(2) == board(1)(1))
      return board(1)(1)

    return Player.NONE
  }

  describe("when the board is empty") {
    it("there should be no winner") {
      val board = Array(
		    Array(Player.NONE, Player.NONE, Player.NONE),
		    Array(Player.NONE, Player.NONE, Player.NONE),
		    Array(Player.NONE, Player.NONE, Player.NONE))

      getWinner(board) should be (Player.NONE)
    }
  }

  describe("when the game is not over yet") {
    it("there should be no winner") {
      val board = Array(
        Array(Player.X,     Player.O, Player.X),
        Array(Player.NONE,  Player.O, Player.NONE),
        Array(Player.NONE,  Player.X, Player.O))

      getWinner(board) should be (Player.NONE)
    }
  }

  describe("when just two X are in a row right side") {
    it("there should be no winner") {
      val board = Array(
        Array(Player.NONE, Player.X,    Player.X),
        Array(Player.NONE, Player.NONE, Player.NONE),
        Array(Player.NONE, Player.NONE, Player.NONE))

      getWinner(board) should be (Player.NONE)
    }
  }

  describe("when just two X are in a row left side") {
    it("there should be no winner") {
      val board = Array(
        Array(Player.X,    Player.X,    Player.NONE),
        Array(Player.NONE, Player.NONE, Player.NONE),
        Array(Player.NONE, Player.NONE, Player.NONE))

      getWinner(board) should be (Player.NONE)
    }
  }

  describe("when three X are in the first row") {
    it("X should be the winner") {
      val board = Array(
        Array(Player.X,    Player.X, Player.X),
        Array(Player.NONE, Player.O, Player.NONE),
        Array(Player.NONE, Player.O, Player.O))

      getWinner(board) should be (Player.X)
    }
  }

  describe("when three X are in the second row") {
    it("X should be the winner") {
      val board = Array(
        Array(Player.NONE, Player.O, Player.NONE),
        Array(Player.X,    Player.X, Player.X),
        Array(Player.NONE, Player.O, Player.O))

      getWinner(board) should be (Player.X)
    }
  }

  describe("when three X are in the last row") {
    it("X should be the winner") {
      val board = Array(
        Array(Player.NONE, Player.O, Player.NONE),
        Array(Player.NONE, Player.O, Player.O),
        Array(Player.X,    Player.X, Player.X))

      getWinner(board) should be (Player.X)
    }
  }

  describe("when three O in a row") {
    it("O should be the winner") {
      val board = Array(
        Array(Player.O,    Player.O, Player.O),
        Array(Player.NONE, Player.X, Player.NONE),
        Array(Player.NONE, Player.X, Player.X))

      getWinner(board) should be (Player.O)
    }
  }

  describe("when three X are in the first column") {
    it("X should be the winner") {
      val board = Array(
        Array(Player.X, Player.O,    Player.NONE),
        Array(Player.X, Player.NONE, Player.NONE),
        Array(Player.X, Player.O,    Player.O))

      getWinner(board) should be (Player.X)
    }
  }
  describe("when three X are in the second column") {
    it("X should be the winner") {
      val board = Array(
        Array(Player.O,    Player.X, Player.NONE),
        Array(Player.NONE, Player.X, Player.NONE),
        Array(Player.O,    Player.X, Player.O))

      getWinner(board) should be (Player.X)
    }
  }

  describe("when three X are in diagonal") {
    it("X should be the winner") {
      val board = Array(
        Array(Player.X,    Player.O, Player.NONE),
        Array(Player.NONE, Player.X, Player.NONE),
        Array(Player.O,    Player.O, Player.X))

      getWinner(board) should be (Player.X)
    }
  }

  describe("when three X are in other diagonal") {
    it("X should be the winner") {
      val board = Array(
        Array(Player.O,    Player.O, Player.X),
        Array(Player.NONE, Player.X, Player.NONE),
        Array(Player.X,    Player.O, Player.NONE))

      getWinner(board) should be (Player.X)
    }
  }
}
