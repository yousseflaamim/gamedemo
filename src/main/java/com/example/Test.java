package com.example;

import com.example.controller.GuessWords;
import com.example.controller.InputWords;
import com.example.pojo.Players;

import java.util.ArrayList;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {

        Players player1 = new Players( );
        Players player2 = new Players( );
        Players player3 = new Players( );
        Players player4 = new Players( );
        ArrayList <Players> list = new ArrayList<>();
        Collections.addAll( list, player1, player2, player3, player4 );

//        InputWords.inputWord( list );
//        test Inputwords function
//        System.out.println(list );
//        System.out.println( list.get( 0 ).getShowingList().length );

        GuessWords.guessWord( list );
    }
}
