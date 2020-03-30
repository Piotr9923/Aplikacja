package com.example.peew;

import java.util.ArrayList;

public class Levels {

    private int levelId;
    private Player player;

    private ArrayList<Platform> platforms;
    private ArrayList<String> levelsList;


    public Levels(Player player, ArrayList<Platform> platforms){

        levelId = 0;
        this.player = player;
        levelsList = new ArrayList<String>();
        this.platforms=platforms;
        createLevels();
    }

    public void loadNextLevel(){


        String actualLevel = levelsList.get(levelId);

        for(int i=0;i<10;i++){
            for(int j=0;j<20;j++){

                if(actualLevel.charAt(20*i+j) == 'p') {player.setY(50*i);player.setX(50*j);}
                if(actualLevel.charAt(20*i+j) == 'g') {platforms.add(new Platform(50*j,50*i));}

            }

        }

        levelId++;
    }

    private void createLevels(){

        levelsList.add(new String("00000000000000000000" +
                "0000000p000000000000" +
                "00000000000000000000" +
                "00000000000000000000" +
                "00000000000000000000" +
                "00000000000000000000" +
                "00000000000000000000" +
                "00000000000000000000" +
                "00000000000000000000" +
                "gggggggggggggggggggg"));


    }


}
