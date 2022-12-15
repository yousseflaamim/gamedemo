package com.example.demo;

import com.example.pojo.Players;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;


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
    public Image img1Horse3;
    public Image img1Horse4;
    public Image img1Horse5;
    public Image img1Horse6;
    public Image img1Horse8;
    public ImageView img1;
    public ImageView img2;
    public Image img2Horse3;
    public Image img2Horse4;
    public Image img2Horse5;
    public Image img2Horse6;
    public Image img2Horse8;
    public Image img3Horse3;
    public Image img3Horse4;
    public Image img3Horse5;
    public Image img3Horse6;
    public Image img3Horse8;
    public ImageView img4;
    public ImageView img3;
    public Image img4Horse3;
    public Image img4Horse4;
    public Image img4Horse5;
    public Image img4Horse6;
    public Image img4Horse8;

    private Stage stage;
    private Scene scene;
    private Parent root;
    boolean playMute = false;
    AudioHandler audioHandler = new AudioHandler();


    Players player1 = new Players( );
    Players player2 = new Players( );
    Players player3 = new Players( );
    Players player4 = new Players( );

    String s = "";

    ArrayList<Players> list = new ArrayList<>();

    Integer playerturn = 0;

    Object[] tmpArr = new Object[3];


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



        Collections.addAll( list, this.player1, this.player2, this.player3, this.player4 );



        String guess1Text = passwordGuess1.getText( );
        String guess2Text = passwordGuess2.getText( );
        String guess3Text = passwordGuess3.getText( );
        String guess4Text = passwordGuess4.getText( );
        this.player1.setSettingWord( guess1Text );
        this.player2.setSettingWord( guess2Text );
        this.player3.setSettingWord( guess3Text );
        this.player4.setSettingWord( guess4Text );

        for (Players players : list) {
            players.setTestingWord( players.getSettingWord() );

        }

//        InputWords.shuffle( list );



        list.forEach( players -> players.setShowingList( players.getTestingWord().toCharArray() ) );
        list.forEach(players -> {
                    int length = players.getShowingList( ).length;
                    char[] tmp = new char[length];
                    players.setTestList( tmp );
                }
        );


        word1.setText( initText( this.player1) );
        word2.setText( initText( this.player2) );
        word3.setText( initText( this.player3) );
        word4.setText( initText( this.player4) );

        word1.setStyle( "-fx-background-color:rgba(255, 255, 68,0.7);" );
        list.forEach(  players-> System.out.println(players ) );

    }

    private String initText(Players players) {
        StringBuilder s = new StringBuilder( );

        for (int i = 0; i < players.getShowingList( ).length; i++) {
            s.append( "*" );
        }
        return s.toString();
    }


    public void inputKeyboard(KeyEvent keyEvent) {

        s = keyEvent.getText( );
        System.out.println(s );

    }

    public void selectPlayer1(ActionEvent actionEvent) {

       tmpArr = getTmp(this.player1, s );

        word1.setText( (String) tmpArr[0] );
        System.out.println(" count " + tmpArr[1] + " playerturn " + tmpArr[2] );

        playerturn = checkPlayersTurn( tmpArr);

        list.forEach(  players -> System.out.print(players.getImage()));

//        selectImage(this.player1, img1, img1Horse3, img1Horse4,img1Horse5,img1Horse6,img1Horse8 );
    }



    public void selectPlayer2(ActionEvent actionEvent) {

        tmpArr = getTmp(this.player2, s );

        word2.setText( (String) tmpArr[0] );
        System.out.println("count " + tmpArr[1] + " playerturn " + tmpArr[2] );

        playerturn = checkPlayersTurn( tmpArr);

        list.forEach(  players -> System.out.print(players.getImage()));

//        selectImage(this.player2, img2, img2Horse3, img2Horse4,img2Horse5,img2Horse6,img2Horse8 );

    }

    public void selectPlayer3(ActionEvent actionEvent) {
       tmpArr= getTmp(this.player3, s );

        word3.setText( (String) tmpArr[0] );
        System.out.println("count " + tmpArr[1] + " playerturn " + tmpArr[2] );

        playerturn = checkPlayersTurn( tmpArr);

        list.forEach(  players -> System.out.print(players.getImage()));

//        selectImage(this.player3, img3, img3Horse3, img3Horse4,img3Horse5,img3Horse6,img3Horse8 );

    }

    public void selectPlayer4(ActionEvent actionEvent) {

        tmpArr = getTmp(this.player4, s );

        word4.setText( (String) tmpArr[0] );

        System.out.println("count " + tmpArr[1] + " playerturn " + tmpArr[2] );

        playerturn = checkPlayersTurn( tmpArr);

        list.forEach(  players -> System.out.print(players.getImage()));
//        selectImage(this.player4, img4, img4Horse3, img4Horse4,img4Horse5,img4Horse6,img4Horse8 );
    }

    private String[] getTmp(Players player, String s) {
        playerturn++;
        String[] arr = new String[3];
        String word = "";
        Integer count = 0;
        char[] chars = s.toCharArray( );
        char[] list = player.getShowingList( );
        char[] tmp = player.getTestList();

        for (int i = 0; i < list.length; i++) {
            if(list[i] == chars[0]){
                tmp[i] = list[i];
                count++;
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

        arr[0] = word;
        arr[1] = count+"";
        arr[2] = playerturn+"";

        return arr;
    }

    private Integer checkPlayersTurn( Object[] tmpArr) {
        playerturn = Integer.parseInt( (String) tmpArr[2] );

        switch (playerturn%4){
            case 1 -> {
                if(Integer.parseInt( (String) tmpArr[1]) == 0) { this.player1.setImage( this.player1.getImage() - 1);}
                selectImage(this.player1, img1, img1Horse3, img1Horse4,img1Horse5,img1Horse6,img1Horse8 );

                word2.setStyle( "-fx-background-color:rgba(255, 255, 68,0.7);" );
                word1.setStyle("-fx-background-color:rgba(0,0,255,0);");


            }
            case 2-> {
                if(Integer.parseInt( (String) tmpArr[1]) == 0) { this.player2.setImage( this.player2.getImage() - 1);}
                selectImage(this.player2, img2, img2Horse3, img2Horse4,img2Horse5,img2Horse6,img2Horse8 );

                word3.setStyle( "-fx-background-color:rgba(255, 255, 68,0.7);" );
                word2.setStyle("-fx-background-color:rgba(0,0,255,0);");

            }
            case 3-> {
                if(Integer.parseInt( (String) tmpArr[1]) == 0) { this.player3.setImage( this.player3.getImage() - 1);}
                selectImage(this.player3, img3, img3Horse3, img3Horse4,img3Horse5,img3Horse6,img3Horse8 );

                word4.setStyle( "-fx-background-color:rgba(255, 255, 68,0.7);" );
                word3.setStyle("-fx-background-color:rgba(0,0,255,0);");
            }
            case 0-> {
                if(Integer.parseInt( (String) tmpArr[1]) == 0) { this.player4.setImage( this.player4.getImage() - 1);}
                selectImage(this.player4, img4, img4Horse3, img4Horse4,img4Horse5,img4Horse6,img4Horse8 );

                word1.setStyle( "-fx-background-color:rgba(255, 255, 68,0.7);" );
                word4.setStyle("-fx-background-color:rgba(0,0,255,0);");
            }
        }
        return playerturn;
    }


    private void selectImage(Players players, ImageView imageView, Image image1, Image image2, Image image3,
                             Image image4, Image image5) {
        switch (players.getImage()){
            case(5)->{imageView.setVisible( false ); }
            case(4)->{imageView.setVisible( true ); imageView.setImage( image1 );}
            case(3)->{imageView.setVisible( true ); imageView.setImage( image2 );}
            case(2)->{imageView.setVisible( true ); imageView.setImage( image3 );}
            case(1)->{imageView.setVisible( true ); imageView.setImage( image4 );}
            case(0)->{imageView.setVisible( true ); imageView.setImage( image5 );}
        }
    }


}
