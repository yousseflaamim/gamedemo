package com.example.controller;

import com.example.pojo.Players;

import java.util.ArrayList;
import java.util.Scanner;

public class GuessWords {

    public static void guessWord(ArrayList <Players> list){

        flag:while (true){
            for (int i = 0; i < list.size( ); i++) {

                list.get(i).setGreenLight( true );

//                test input a letter
                if(!list.get( i ).getFlag( )){
                    matchLetter( list, i );
                }

                list.get(i).setGreenLight( false );

//                finish the game
                if(finishGame( list )>=3){
                    break flag;
                }
            }
        }

    }

    private static void matchLetter(ArrayList <Players> list, int i) {
        Scanner scanner = new Scanner( System.in );
        System.out.println("please input a letter, player " + list.get( i ));
        char s = scanner.next( ).toLowerCase( ).charAt( 0 );
        char[] chars = list.get( i ).getTestList( );

        for (int j = 0; j < list.get( i ).getShowingList().length; j++) {
            if(s == list.get( i ).getShowingList()[j]){

                chars[j] = s;
                list.get( i ).setImage( list.get(i).getImage()-1 );
            }
        }
        
        list.get( i ).setTestList( chars );
        
        System.out.println("Image's number: " + list.get( i ).getImage() );

        for (char c : list.get( i ).getTestList( )) {
            if(c>122 || c<97){
                System.out.print("* " );
            }else{
                System.out.print(c + " ");
            }
        }

        System.out.println( );
    }

    private static long finishGame(ArrayList <Players> list){
        return list.stream( ).filter( players -> players.getImage( ) <= 0).count();
    }

}
