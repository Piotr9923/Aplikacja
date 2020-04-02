package com.example.peew;

import java.util.ArrayList;

public class Levels {

    private int levelId;
    private Player player;

    private ArrayList<Platform> platforms;
    private ArrayList<String> levelsList;
    private ArrayList<Ball> balls;


    public Levels(Player player, ArrayList<Platform> platforms, ArrayList<Ball> balls){

        levelId = 0;
        this.player = player;
        levelsList = new ArrayList<String>();
        this.platforms = platforms;
        this.balls = balls;
        createLevels();
    }

    public void loadNextLevel(){

        platforms.removeAll(platforms);
        balls.removeAll(balls);

        String actualLevel = levelsList.get(levelId);
        /* 0-wolna przestrzeń | 1-platforma czarna | 2-platforma z trawą | 3-gracz | 4-piłka | 5-bramka */
        for(int i=0;i<20;i++){
            for(int j=0;j<36;j++){

                if(actualLevel.charAt(36*i+j) == '1') {platforms.add(new Platform(50*j,50*i,false));}
                else if(actualLevel.charAt(36*i+j) == '2') {platforms.add(new Platform(50*j,50*i,true));}
                else if(actualLevel.charAt(36*i+j) == '3') {player.setStartingCoordinate(50*j,50*i);player.setStartingPosition();}
                else if(actualLevel.charAt(36*i+j) == '4') {balls.add(new Ball(50*j,50*i));}

            }

        }

        levelId++;
    }

    private void createLevels(){

        levelsList.add(new String("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000030040000000000000000000000000000002222222222222222222000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000022222222222222222222222222222222000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));


    }


}
