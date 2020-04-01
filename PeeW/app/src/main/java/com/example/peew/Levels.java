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
        // 0-wolna przestrzeń | 1-platforma | 2-gracz | 3-piłka | 4-bramka
        for(int i=0;i<20;i++){
            for(int j=0;j<36;j++){

                if(actualLevel.charAt(36*i+j) == '2') {player.setStartingCoordinate(50*j,50*i);player.setStartingCoordinate();}
                if(actualLevel.charAt(36*i+j) == '1') {platforms.add(new Platform(50*j,50*i));}

            }

        }
        System.out.println("platorms-"+platforms.size())
;        levelId++;
    }

    private void createLevels(){

        levelsList.add(new String("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000002001000000000000000000000000000000000011000000000000001111111110000000111111111111000000000000000000010000000000000000000001100000000000000000000000000000000010010000000000000000000000101111111100001000000000110001000010000000000000000100000001110000000000000000000000000000000001110000000001000000000000000000000010000000000000000000000000000000000000000000000000011100110101010111111100000000000000111100000000000000000000000000000001111100000000000000000000000000000011111100000000000000000000000000000111111100000000000000000000000000111111111100000000000000000000000000"));


    }


}
