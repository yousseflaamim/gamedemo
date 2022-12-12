package com.example.controller;

import com.example.pojo.Players;

import java.util.*;

public class InputWords {
    public static void inputWord(ArrayList <Players> list){

//        will connect to javaFX
        Scanner scanner = new Scanner( System.in );
        list.forEach(  players -> {
            System.out.println("please input a word, which includes 5 characters" );

            String s = scanner.nextLine( ).toLowerCase( ).trim( );
            if(s.length()!=5){
                System.out.println("the word should have 5 characters" );
                System.exit( 0 );
            }else {
                players.setSettingWord( s );}
        });



//      shuffle the contesters.
        shuffle( list );

//      split a word into an array
        list.forEach( players -> players.setShowingList( players.getTestingWord().toCharArray() ) );
        list.forEach(players -> {
                    int length = players.getShowingList( ).length;
                    char[] tmp = new char[length];
                    players.setTestList( tmp );
                }
        );
    }

    private static void shuffle(ArrayList <Players> list) {
        Random rand = new Random();
        int shuffleOrder = rand.nextInt( 1,4 );
        list.get( 0 ).setTestingWord( list.get(shuffleOrder).getSettingWord() );
        list.get( shuffleOrder ).setTestingWord( list.get(0).getSettingWord() );
        List <Integer> numArr =  new ArrayList<>( );
        Collections.addAll( numArr, 1 ,2 , 3 );
        Integer[] integers = numArr.stream( ).filter( integer -> integer != shuffleOrder ).toArray( Integer[]::new );
        list.get( integers[0] ).setTestingWord( list.get( integers[1] ).getSettingWord() );
        list.get( integers[1] ).setTestingWord( list.get( integers[0] ).getSettingWord() );
    }
}
