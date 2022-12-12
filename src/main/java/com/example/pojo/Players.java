package com.example.pojo;

import lombok.*;

@Data
public class Players {

    private String settingWord;
    private String testingWord;
    private char[] showingList;
    private char[] testList;
    private Boolean greenLight = false;
    private Integer image = 5;
    private Boolean flag = false;

}
