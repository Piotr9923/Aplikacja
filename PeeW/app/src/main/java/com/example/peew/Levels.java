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
    private GameActivity gameActivity;
    private boolean isFinished=false;

    public Levels(Player player, ArrayList<Platform> platforms, ArrayList<Ball> balls,ArrayList<Goal> goals, GameActivity gameActivity) {

        levelId = 0;
        this.player = player;
        levelsList = new ArrayList<String>();
        this.platforms = platforms;
        this.balls = balls;
        this.goals = goals;
        this.gameActivity = gameActivity;
        createLevels();
    }

    public boolean getIsFinished(){
        return isFinished;
    }

    public void loadNextLevel() {

        platforms.removeAll(platforms);
        balls.removeAll(balls);
        goals.removeAll(goals);

        if(levelId>=levelsList.size()){

            Intent intent = new Intent(gameActivity, WinGameActivity.class);
            gameActivity.startActivity(intent);
            gameActivity.finish();
            isFinished = true;
            levelId =0;
        }
        else {

            String actualLevel = levelsList.get(levelId);

            /* 0-wolna przestrzeń | 1-platforma czarna | 2-platforma z trawą | 3-gracz | 4-piłka | 5-bramka */
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 36; j++) {

                    if (actualLevel.charAt(36 * i + j) == '1') {
                        platforms.add(new Platform(50 * j, 50 * i, false));
                    } else if (actualLevel.charAt(36 * i + j) == '2') {
                        platforms.add(new Platform(50 * j, 50 * i, true));
                    } else if (actualLevel.charAt(36 * i + j) == '3' && actualLevel.charAt(36 * i + j + 36) == '3') {
                        player.setStartingCoordinate(50 * j, 50 * i);
                        player.setStartingPosition();
                    } else if (actualLevel.charAt(36 * i + j) == '4') {
                        balls.add(new Ball(50 * j, 50 * i));
                    } else if (actualLevel.charAt(36 * i + j) == '5') {
                        goals.add(new Goal(50 * j, 50 * i));
                    }


                }

            }

            levelId++;
        }
    }

    private void createLevels() {

        levelsList.add(new String("000000000000000004000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000030000000000000000000000000000000000030000000001000000000000000000000000000000000001000000000000222222222222222222222222200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
        //levelsList.add(new String("000000000000000000000000000000000000000000000000000000000000000004000000000000000000000000000000000022200000000000000000000000000000000000000000001100000000000000000000000000002000001500000000000000000000000000000000001500000000000000000000000000000200022222222222222222222222222222000000000000000000000000000000000000000002000000000000000000000000000000000020000000000000000000000000000000000200000000000000000000000000000000020000003000000000000000000000022202020000003000000000000000000002000000000000000000000000000000000020000000000000222222222222222222222200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
       // levelsList.add(new String("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000030000000000020000000000000000000000030022000000000202002000000000000000222000020002000000000200000000000000000000000000000000000000000000000000000000000200000000000000220022200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000040000000000000000000000000000000000011000000000000000000000000000000000051000000000000000000000000000000000051222222222222222222222222222222222222111111111111111111111111111111111111"));
     //   levelsList.add(new String("000000000000000000000000000000000000000000000000000000400000000000000000000000000000000000000000000000000000000000000000000000000000000001100000000000000000000000000000000005100000000202222222222222222222222222200000000000000000000000000000000000000000020000000000000000000000000000000000000000000000000000000000000000000000000200000000000000300000000000000000220002000000000000300000000000000011020000002000000000000000000000000051002000000020000000000000000000000451000022200000222222222222022002002221000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));

    }

}
