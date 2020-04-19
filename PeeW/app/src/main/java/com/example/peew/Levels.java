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

            for (int i = 0; i < actualLevel.length(); i++) {

                if(column==36) {row++;column=0;}
                if(row==21) break;

                    if (actualLevel.charAt(i) == '1') {
                        platforms.add(new Platform(50 * column, 50 * row, false));
                    } else if (actualLevel.charAt(i) == '2') {
                        platforms.add(new Platform(50 * column, 50 * row, true));
                    } else if (actualLevel.charAt(i) == '3' && actualLevel.charAt( i ) == '3') {
                        player.setStartingCoordinate(50 * column, 50 * row);
                        player.setStartingPosition();
                    } else if (actualLevel.charAt(i) == '4') {
                        balls.add(new Ball(50 * column, 50 * row));
                    } else if (actualLevel.charAt(i) == '5') {
                        goals.add(new Goal(50 * column, 50 * row));
                    }else if (actualLevel.charAt(i) == '6') {

                        int type = Integer.parseInt(actualLevel.charAt( i+1 )+"");
                        obcastles.add(new Obcastle(50 * column, 50 * row,type));
                        i++;
                    }

                    column++;
                }



            levelId++;
        }
    }

    private void createLevels() {
        levelsList.add(new String("000001111111111111111111111111100000000001000000000000000000000005100000000001000000000000000000000005100000000001000000000000000000000005100000000001000000000000000000000001100000000001000000000000000000000000100000000001300000000000000000000000100000000001300000000000000000000000100000000001000000000000004000000000100000000002222222222222222222222222200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));

        levelsList.add(new String("0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000003000000000000000000000011000000000003000000000000000000000051000000000000000006100000004000000005100000000002222222222222222222222222200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
        levelsList.add(new String("000000000000000000000000000006411110000000000000000000000000000000641111000000000000000000000000000000064111100000000000000000000000000000006411110000000000000000000000000000000641111000000000000000000000000000000005511000000000000000000004000000000005511000000000000000000000000000000064111100000000003000000000000000000006411110000000000300000000000000000000641111000000000000000000000000000000064111100002222222222222222222222222222222200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));

    }

}
