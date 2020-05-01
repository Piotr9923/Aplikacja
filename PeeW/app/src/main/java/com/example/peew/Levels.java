package com.example.peew;

import android.content.Intent;

import java.util.ArrayList;

public class Levels {

    private int levelId;
    private Player player;

    private ArrayList<Platform> platforms;
    private ArrayList<String> levelsList;
    private ArrayList<Ball> balls;
    private ArrayList<Goal> goals;
    private ArrayList<Obcastle> obcastles;

    private GameActivity gameActivity;
    private boolean isFinished=false;

    public Levels(Player player, ArrayList<Platform> platforms, ArrayList<Ball> balls,ArrayList<Goal> goals, ArrayList<Obcastle> obcastles, GameActivity gameActivity) {

        levelId = 0;
        this.player = player;
        levelsList = new ArrayList<String>();
        this.platforms = platforms;
        this.balls = balls;
        this.goals = goals;
        this.gameActivity = gameActivity;
        this.obcastles = obcastles;
        createLevels();
    }

    public boolean getIsFinished(){
        return isFinished;
    }

    public void loadNextLevel() {

        platforms.removeAll(platforms);
        balls.removeAll(balls);
        goals.removeAll(goals);
        obcastles.removeAll(obcastles);

        if(levelId>=levelsList.size()){

            Intent intent = new Intent(gameActivity, WinGameActivity.class);
            gameActivity.startActivity(intent);
            gameActivity.finish();
            isFinished = true;
            levelId =0;
        }
        else {

            String actualLevel = levelsList.get(levelId);

            /* 0-wolna przestrzeń | 1-platforma czarna | 2-platforma z trawą | 3-gracz | 4-piłka | 5-bramka | 6-przeszkoda*/

            int row=0,column=0;
            int playerColumn=0;

            for (int i = 0; i < actualLevel.length(); i++) {

                if(column==36) {row++;column=0;}
                if(row==21) break;

                    if (actualLevel.charAt(i) == '1') {
                        platforms.add(new Platform(50 * column, 50 * row, false));
                    } else if (actualLevel.charAt(i) == '2') {
                        platforms.add(new Platform(50 * column, 50 * row, true));
                    } else if (actualLevel.charAt(i) == '3') {
                        if(playerColumn == column){
                            player.setStartingCoordinate(50 * column, 50 * (row-1));
                            player.setStartingPosition();
                        }
                        playerColumn=column;
                    } else if (actualLevel.charAt(i) == '4') {
                        balls.add(new Ball(50 * column, 50 * row));
                    } else if (actualLevel.charAt(i) == '5') {
                        goals.add(new Goal(50 * column, 50 * row));
                    }else if (actualLevel.charAt(i) == '6') {

                        int type = Integer.parseInt(actualLevel.charAt( i+1 )+"");
                        if(actualLevel.charAt(i+2) == '8') {obcastles.add(new Obcastle(50 * column, 50 * row,type,true));i++;}
                        else  obcastles.add(new Obcastle(50 * column, 50 * row,type));
                        i++;
                    }

                    column++;
                }

            levelId++;
        }
    }

    private void createLevels() {
        levelsList.add(new String("000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111111111111111111000000100000000000000000000000000001000000100000000000000000000000000001000000100000000000000000000000000001000000100000000000000000000000000001000000100000000000000000000000000001000000100000000000000000000000000001000000100000000000000000000000000001000000100000000000000000000000000011000000100000000000000000000000000051000000100000000001000000000100000051000000100000000010000000001000000011000000100000000100000000010000000001000000100304001000000000100000000001000000100300000000010000000001000001000000111111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000"));


        levelsList.add(new String("0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000003000000000000000000000011000000000003000000000000000000000051000000000000000006100000004000000005100000000002222222222222222222222222200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
        levelsList.add(new String("0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000300000000000000000000000000000000000300000111111111111111111111110000000000000063800063800063800000000638005100000000000000618000618000618000040006180051000000222222222222222222222222222222000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
        levelsList.add(new String("000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111111111111111111000000100000000000000000000000000001000000100000000000000000000000000001000000100000000000000000000000000001000000100000000000000000000000000001000000100000000000000000000000000001000000100000000000000000000000000001000000100000000000000000000000000001000000100000000000000000000000000011000000100000000000000000000000000051000000100000000001000000000100000051000000100000000010000000001000000011000000100000000100000000010000000001000000100304001000000000100000000001000000100300000000010000000001000001000000111111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000"));
        levelsList.add(new String("000000000000000000000000000006411110000000000000000000000000000000641111000000000000000000000000000000064111100000000000000000000000000000006411110000000000000000000000000000000641111000000000000000000000000000000005511000000000000000000004000000000005511000000000000000000000000000000064111100000000003000000000000000000006411110000000000300000000000000000000641111000000000000000000000000000000064111100002222222222222222222222222222222200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
        levelsList.add(new String("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000300000000000000000000000000000000000300000000000000000000000000000000000000000000010000000000000000000000000000000000010000000000000000000000000000000000010000000000000000000000000000000000010000000000000000000000000000000000010000000000000000000000000000000000010000000110000000000000000000000000010000000150000000000000000000000000010000011150000001004000000000000004000000051222222222222222220022222222222222222000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
        levelsList.add(new String("620300000000000000000000000000000001162030000000000000000000000004000000516200000000000000000000000000000000051222200202002020202002020022200000222000000000000000000000000000000000000616161616161616161616161616161616161616161616161616161000000000636363636363636363636363636363636363636363636363636363000000000000000000000000000000000000000000000000000000000000000000000000000000000110000000000000000000000000000000000150000000000000000000000000000020000150000004000000000000000000000000000222220002202000200200200200200000000000000000000000000000000000002000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
        levelsList.add(new String("00000000000000000000000000000000000000300000000000000000000000000000000000300000000000000000000000040000000022222222222222222222222222222200100100000100000000000000000000000100100100000100000000000000000000000100100100000100000000000000000000000162864810010000010000000000000000000000010010010000010000000000000000000000010016286481111111000000000000000000000001001001162805510000000000000000000000015510011628055100000000000000000000000155100116280551000000000000000000000001111001162801110000000000000000000000000000011628000000000000000000000000000000000116280000000000000000000000000000000001162800000000000000000000000000000000011628040000000000000000000000000000000116280000000000000000000000000000000001222222222222222222222222222222222222"));
        levelsList.add(new String("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011000000000000000000000000000000000051000000000000000000000000000000000051000000000000000000000000000202222222000003000000011000000000020000000000000003004000051100000002000000000000000000000000051000400200000000000000000222222222222222222000000000000000000000000000000000000000000000000000"));
        levelsList.add(new String("0000000000000000000000000000000000000000000000000000000000000000000000000000000300000000000000000000000000000000000300000000000000000000000000110000000000000000000000000000000000510000000000000000000000000040061000051000000020200202002020020022222222222000000000000000000000000000000000000000000000000000000000000000000000000000000061616161616161616161616161616161616161616100000000000000011111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011000000000000000000000000000000004051000222200200200200200200200200222222000000000000000000000000000000000000000000000000000000000000000000000000"));
        levelsList.add(new String("00000000000000000000000000000000000000000000000000000000000000000000000003000000000000000000000000000000000003000000000000000000000000000000000000000000000000000000000000000000000000061006100610061000400000000000000000002222222222222222200000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000000000000000000000000000000005100000000000000000000000000000000005100000000000000000000000000000000005100000000000000000000000000000000005100000000000000000000000000000000002200000000000000000000000000000000000000000000000000000000000000000000000000040000610000000000000000000000000000222222222222222220000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
        levelsList.add(new String("0000000000000000000000000000000000000000000000000000000000000000000000110003000000000000000000610000000000051000300000000000000000641620000000000510000000000000400000064111620000000005122222222222222200006411111620000222222000000000000000000006411162000000000000000000000000000000006416200000000000000000000000000000000006300000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000110000000000000000000000000000000000510000000000400000000006161616100000000051222222222222222000000111100000222222000000000000000000000000000000000000000000000000000000000000000000000000"));


    }



}
