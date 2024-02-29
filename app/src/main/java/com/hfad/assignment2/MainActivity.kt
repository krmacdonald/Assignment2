package com.hfad.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun playGame() {
        val FIR_board = FourInARow()
        var currentState = GameConstants.PLAYING
        do {
                //Sets player move based on input if they didn't quit
                FIR_board.setMove(GameConstants.RED, 5)

                //Sets cpu position
                FIR_board.setMove(GameConstants.BLUE, FIR_board.computerMove)

                //Checks if there's a row matching
                currentState = FIR_board.checkForWinner()

            //Handles playing again logic, displays messages based on who wins
            if(currentState != GameConstants.PLAYING){
                if(currentState == GameConstants.RED_WON){
                    println("RED WON!");
                }else{
                    println("BLUE WON!");
                }
            }
        } while (currentState == GameConstants.PLAYING)
    }

}