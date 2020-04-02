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
        // 0-wolna przestrzeń | 1-platforma czarna | 2-platforma z trawą | 3-gracz | 4-piłka | 5-bramka
        for(int i=0;i<20;i++){
            for(int j=0;j<36;j++){

                if(actualLevel.charAt(36*i+j) == '1') {platforms.add(new Platform(50*j,50*i,false));}
                else if(actualLevel.charAt(36*i+j) == '2') {platforms.add(new Platform(50*j,50*i,true));}
                else if(actualLevel.charAt(36*i+j) == '3') {player.setStartingCoordinate(50*j,50*i);player.setStartingCoordinate();}

            }

        }
        System.out.println("platorms-"+platforms.size())
;        levelId++;
    }

    private void createLevels(){

        levelsList.add(new String("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000003002000000000000000000000000000000000021000000000000002222222220000000222211222222000000000000000000020000000000000000000002200000000000000000000000000000000020020000000000000000000000202222222200002000000000220002000020000000000000000200000002110000000000000000000000000000000001110000000002000000000000000000000020000000000000000000000000000000000000000000000000022200220202020222222200000000000000211100000000000000000000000000000002111100000000000000000000000000000021111100000000000000000000000000000211111100000000000000000000000000222111111100000000000000000000000000"));


    }


}
