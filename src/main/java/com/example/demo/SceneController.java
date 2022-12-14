package com.example.demo;

import com.example.controller.InputWords;
import com.example.pojo.Players;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.function.Consumer;


public class SceneController {
    public Button start;
    public PasswordField passwordGuess1;
    public PasswordField passwordGuess3;
    public PasswordField passwordGuess4;
    public PasswordField passwordGuess2;

    public Button play1;
    public Button play2;
    public Button play3;
    public Button play4;
    public Label word1;
    public Label word2;
    public Label word3;
    public Label word4;

    private Stage stage;
    private Scene scene;
    private Parent root;
    boolean playMute = false;
    AudioHandler audioHandler = new AudioHandler();


    Players player1 = new Players( );
    Players player2 = new Players( );
    Players player3 = new Players( );
    Players player4 = new Players( );

    String s = new String(  );



    public  void switchToScene1(ActionEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("Scene.fxml"));
        stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public  void switchToScene2(ActionEvent event) throws IOException {

        Parent root =  FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void playMuteAudio(){
        playMute = !playMute;

        audioHandler.playMuteSong(playMute);

    }

    public void startGame(ActionEvent actionEvent) {




        String guess1Text = passwordGuess1.getText( );
        String guess2Text = passwordGuess2.getText( );
        String guess3Text = passwordGuess3.getText( );
        String guess4Text = passwordGuess4.getText( );
        this.player1.setSettingWord( guess1Text );
        this.player2.setSettingWord( guess2Text );
        this.player3.setSettingWord( guess3Text );
        this.player4.setSettingWord( guess4Text );




        Random random = new Random( );
        int i = random.nextInt( 1, 4 );
        switch (i){
            case(1)->{
                this.player1.setTestingWord( this.player2.getSettingWord() );
                this.player2.setTestingWord( this.player1.getSettingWord() );
                this.player3.setTestingWord( this.player4.getSettingWord() );
                this.player4.setTestingWord( this.player3.getSettingWord() );
            }
            case(2)->{
                this.player1.setTestingWord( this.player3.getSettingWord() );
                this.player3.setTestingWord( this.player1.getSettingWord() );
                this.player2.setTestingWord( this.player4.getSettingWord() );
                this.player4.setTestingWord( this.player2.getSettingWord() );
            }
            case(3)->{
                this.player1.setTestingWord( this.player4.getSettingWord() );
                this.player4.setTestingWord( this.player1.getSettingWord() );
                this.player2.setTestingWord( this.player3.getSettingWord() );
                this.player3.setTestingWord( this.player2.getSettingWord() );
            }
        }

        this.player1.setShowingList( this.player1.getTestingWord().toLowerCase().trim().toCharArray() );
        this.player2.setShowingList( this.player2.getTestingWord().toLowerCase().trim().toCharArray() );
        this.player3.setShowingList( this.player3.getTestingWord().toLowerCase().trim().toCharArray() );
        this.player4.setShowingList( this.player4.getTestingWord().toLowerCase().trim().toCharArray() );

        char[] tmp1 = new char[this.player1.getTestingWord( ).trim( ).length( )];
        char[] tmp2 = new char[this.player2.getTestingWord( ).trim( ).length( )];
        char[] tmp3 = new char[this.player3.getTestingWord( ).trim( ).length( )];
        char[] tmp4 = new char[this.player4.getTestingWord( ).trim( ).length( )];

        this.player1.setTestList( tmp1 );
        this.player2.setTestList( tmp2 );
        this.player3.setTestList( tmp3 );
        this.player4.setTestList( tmp4 );


        System.out.println(this.player1 );
        System.out.println(this.player2 );
        System.out.println(this.player3 );
        System.out.println(this.player4 );
        System.out.println(s );


    }

    public void inputKeyboard(KeyEvent keyEvent) {

        s = keyEvent.getText( );

    }

    public void setPlayer1(Players player1) {
        this.player1 = player1;
    }
    
    public  void setPlayer2(Players player2){
        this.player2 = player2;
    }    
    public  void setPlayer3(Players player3){
        this.player3 = player3;
    }    
    public  void setPlayer4(Players player4){
        this.player4 = player4;
    }

    public Players getPlayer1() {
        return player1;
    }

    public Players getPlayer2() {
        return player2;
    }

    public Players getPlayer3() {
        return player3;
    }

    public Players getPlayer4() {
        return player4;
    }

    public void selectPlayer1(ActionEvent actionEvent) {


        String word = getTmp(this.player1, s );

        word1.setText( word );
    }


    public void selectPlayer2(ActionEvent actionEvent) {

        String word = getTmp(this.player2, s );

        word2.setText( word );

    }

    public void selectPlayer3(ActionEvent actionEvent) {
        String word = getTmp(this.player3, s );

        word3.setText( word );

    }

    public void selectPlayer4(ActionEvent actionEvent) {

        String word = getTmp(this.player4, s );

        word4.setText( word );

    }

    private String getTmp(Players player, String s) {
        String word = "";
        char[] chars = s.toCharArray( );
        char[] list = player.getShowingList( );
        char[] tmp = player.getTestList();

        for (int i = 0; i < list.length; i++) {
            if(list[i] == chars[0]){
                tmp[i] = list[i];
            }
        }
        player.setTestList( tmp );

        for (char c : tmp) {
            if (c == 0){
                word+='-';
            }else{
                word+=c;
            }

        }
        System.out.println(player );
        return word;
    }


}
