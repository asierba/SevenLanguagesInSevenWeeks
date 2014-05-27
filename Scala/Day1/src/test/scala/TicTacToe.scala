import org.scalatest._

class TicTacToe extends FunSpec with ShouldMatchers {

  object Player extends Enumeration {
    type Player = Value
    val NONE = Value(' ')
    val X = Value('X')
    val O = Value('O')
  }

  import Player._

  def getWinner(board : List[List[Player]]) : Player = {
    if(winner(board, Player.X))
      return Player.X

    if(winner(board, Player.O))
      return Player.O

    Player.NONE
  }

  def winner(board : List[List[Player]], player: Player) : Boolean =
    threeInARow(board, player) || threeInAColumn(board, player) || threeInADiagonal(board, player)


  def threeInARow(board : List[List[Player]], player: Player) : Boolean = {
    for(row <- board) {
      if(row.forall(x => x == player)) {
       return true
      }
    }
    false
  }

  def threeInAColumn(board : List[List[Player]], player: Player) : Boolean = {
    threeInARow(board.transpose, player)
  }

  def threeInADiagonal(board : List[List[Player]], player: Player) : Boolean =  {
    if (board(0)(0) == player &&  board(1)(1) == player && board(2)(2) == player)
      return true

    if (board(2)(0) == player &&  board(1)(1) == player &&  board(0)(2) == player)
      return true

    false
  }

  describe("when the board is empty") {
    it("there should be no winner") {
      val board = List(
		    List(Player.NONE, Player.NONE, Player.NONE),
		    List(Player.NONE, Player.NONE, Player.NONE),
		    List(Player.NONE, Player.NONE, Player.NONE))

      getWinner(board) should be (Player.NONE)
    }
  }

  describe("when the game is not over yet") {
    it("there should be no winner") {
      val board = List(
        List(Player.X,     Player.O, Player.X),
        List(Player.NONE,  Player.O, Player.NONE),
        List(Player.NONE,  Player.X, Player.O))

      getWinner(board) should be (Player.NONE)
    }
  }

  describe("when just two X are in a row right side") {
    it("there should be no winner") {
      val board = List(
        List(Player.NONE, Player.X,    Player.X),
        List(Player.NONE, Player.NONE, Player.NONE),
        List(Player.NONE, Player.NONE, Player.NONE))

      getWinner(board) should be (Player.NONE)
    }
  }

  describe("when just two X are in a row left side") {
    it("there should be no winner") {
      val board = List(
        List(Player.X,    Player.X,    Player.NONE),
        List(Player.NONE, Player.NONE, Player.NONE),
        List(Player.NONE, Player.NONE, Player.NONE))

      getWinner(board) should be (Player.NONE)
    }
  }

  describe("when three X are in the first row") {
    it("X should be the winner") {
      val board = List(
        List(Player.X,    Player.X, Player.X),
        List(Player.NONE, Player.O, Player.NONE),
        List(Player.NONE, Player.O, Player.O))

      getWinner(board) should be (Player.X)
    }
  }

  describe("when three X are in the second row") {
    it("X should be the winner") {
      val board = List(
        List(Player.NONE, Player.O, Player.NONE),
        List(Player.X,    Player.X, Player.X),
        List(Player.NONE, Player.O, Player.O))

      getWinner(board) should be (Player.X)
    }
  }

  describe("when three X are in the last row") {
    it("X should be the winner") {
      val board = List(
        List(Player.NONE, Player.O, Player.NONE),
        List(Player.NONE, Player.O, Player.O),
        List(Player.X,    Player.X, Player.X))

      getWinner(board) should be (Player.X)
    }
  }

  describe("when three O in a row") {
    it("O should be the winner") {
      val board = List(
        List(Player.O,    Player.O, Player.O),
        List(Player.NONE, Player.X, Player.NONE),
        List(Player.NONE, Player.X, Player.X))

      getWinner(board) should be (Player.O)
    }
  }

  describe("when three X are in the first column") {
    it("X should be the winner") {
      val board = List(
        List(Player.X, Player.O,    Player.NONE),
        List(Player.X, Player.NONE, Player.NONE),
        List(Player.X, Player.O,    Player.O))

      getWinner(board) should be (Player.X)
    }
  }
  describe("when three X are in the second column") {
    it("X should be the winner") {
      val board = List(
        List(Player.O,    Player.X, Player.NONE),
        List(Player.NONE, Player.X, Player.NONE),
        List(Player.O,    Player.X, Player.O))

      getWinner(board) should be (Player.X)
    }
  }

  describe("when three X are in diagonal") {
    it("X should be the winner") {
      val board = List(
        List(Player.X,    Player.O, Player.NONE),
        List(Player.NONE, Player.X, Player.NONE),
        List(Player.O,    Player.O, Player.X))

      getWinner(board) should be (Player.X)
    }
  }

  describe("when three X are in other diagonal") {
    it("X should be the winner") {
      val board = List(
        List(Player.O,    Player.O, Player.X),
        List(Player.NONE, Player.X, Player.NONE),
        List(Player.X,    Player.O, Player.NONE))

      getWinner(board) should be (Player.X)
    }
  }
}
