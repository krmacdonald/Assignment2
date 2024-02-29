package com.hfad.assignment2
/**
 * TicTacToe class implements the interface
 * @author krmacdonald
 * @date 2/4/2024
 */
class FourInARow
/**
 * clear board and set current player
 */
    : IGame {
    // game board in 2D array initialized to zeros
      private val board = Array(GameConstants.ROWS) { IntArray(GameConstants.COLS){0} }

    override fun clearBoard() {
        //Nested for loop that sets all values to 0
        for (row in 0..<GameConstants.ROWS) {
            for (col in 0..<GameConstants.COLS) {
                board[row][col] = GameConstants.EMPTY
            }
        }
    }

    override fun setMove(player: Int, location: Int) {
        //Checks for which player is next
        if(player == GameConstants.RED){
            //Replaces location on board with player marker if spot is empty
            if(board[location/6][location%6] == GameConstants.EMPTY) {
                board[location / 6][location % 6] = GameConstants.RED
            }
        }else if(player == GameConstants.BLUE){
            //Same as previous if statement but for player 2
            if(board[location/6][location%6] == GameConstants.EMPTY) {
                board[location / 6][location % 6] = GameConstants.BLUE
            }
        }

    }

    override val computerMove: Int
        get() = generateComputerMove() //Calls the generateComputerMove function to find next available spot

    /**
     * Returns computer move by scanning array. If no available spots, returns -1.
     */
    private fun generateComputerMove(): Int{
        for(i in 0 ..< 35){
            if(board[i/6][i%6] == GameConstants.EMPTY){
                return i
            }
        }
        return -1
    }
    /**
    Checks for the winner with nested for loops, returns game status constant based on result
     */
    override fun checkForWinner(): Int {
        //loop for vertical and horizontal checks
        for(i in 0..< 3) {
            for (j in 0..<6) {
                //Horizontal victory check
                if (board[i][j] == board[i + 1][j] && board[i + 1][j] == board[i + 2][j] && board[i + 2][j] == board[i + 3][j]) {
                    if (board[i][j] == GameConstants.RED) {
                        return GameConstants.RED_WON
                    }
                    else if (board[i][j] == GameConstants.BLUE) {
                        return GameConstants.BLUE_WON
                    }
                }
                //Vertical victory check
                else if (board[j][i] == board[j][i + 1] && board[j][i + 1] == board[j][i + 2] && board[j][i + 2] == board[j][i + 3]) {
                    if (board[j][i] == GameConstants.RED) {
                        return GameConstants.RED_WON
                    }
                    else if (board[j][i] == GameConstants.BLUE) {
                        return GameConstants.BLUE_WON
                    }
                }
            }
        }
        //loop for diag win
        for(i in 0 ..< 3){
            for(j in 0 ..<3){
                if(board[i][j] == board[i + 1][j + 1] && board[i + 1][j + 1] == board[i + 2][j + 2] && board[i + 2][j + 2] == board[i + 3][j + 3]){
                    if (board[i][j] == GameConstants.RED) {
                        return GameConstants.RED_WON
                    }
                    else if (board[i][j] == GameConstants.BLUE) {
                        return GameConstants.BLUE_WON
                        }
                }
                if(board[5-i][5-j] == board[4-i][4-j] && board[4-i][4-j] == board[3-i][3-j] && board[3-i][3-j] == board[2-i][2-j]){
                    if (board[5-i][5-j] == GameConstants.RED){
                        return GameConstants.RED_WON
                    }
                    else if (board[5-i][5-j] == GameConstants.BLUE) {
                        return GameConstants.BLUE_WON
                    }
                }
            }
        }
        //if there's no win, return the playing status
        return GameConstants.PLAYING
    }

    /**
     * Print the game board
     */
    fun printBoard() {
        for (row in 0..<GameConstants.ROWS) {
            for (col in 0..<GameConstants.COLS) {
                printCell(board[row][col]) // print each of the cells
                if (col != GameConstants.COLS - 1) {
                    print("|") // print vertical partition
                }
            }
            println()
            if (row != GameConstants.ROWS - 1) {
                println("---------------------") // print horizontal partition
            }
        }
        println()
    }

    /**
     * Print a cell with the specified "content"
     * @param content either BLUE, RED or EMPTY
     */
    private fun printCell(content: Int) {
        when (content) {
            GameConstants.EMPTY -> print("   ")
            GameConstants.BLUE -> print(" B ")
            GameConstants.RED -> print(" R ")
        }
    }
}

