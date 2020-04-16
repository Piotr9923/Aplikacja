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
                    }else if (actualLevel.charAt(36 * i + j) == '6') {
                        obcastles.add(new Obcastle(50 * j, 50 * i));
                    }


                }

            }

            levelId++;
        }
    }

    private void createLevels() {

        levelsList.add(new String("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000300004000000011000000000000000000000300000000000051000000000000000600000000000000000051000000000002222222222222222222222222222222200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
        levelsList.add(new String("000001111111111111111111111111111100000001000000000000000000000000100100000001000000000000000000000000100100000001000000000000000000000000100100000001000000000000000000000000111100000001000000000000000000000000551100000001000000000000400000000000551100000001000000000000000000000000111100000001003000000000000000000000100100000001003000000000000000000000100100000001000000000000000000000000100100000002222222222222222222222222222200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
        levelsList.add(new String("000000000000000000000000000000000000000000000000000000000000000000010000000000100000000000000000000000010000000000100000000000000000000000010000000000100000000000000000000000010000000000100000000000000000000000010000000000104000000000000000000040010000000000100000000000000000000000010000000000100000030000000000000000010000110000100000030000000000000000010011150000000000000000000000000000000051222222222222222200222222222222222222111111111111111100111111111111111111111111111111111100111111111111111111111111111111111100111111111111111111111111111111111100111111111111111111111111111111111100111111111111111111111111111111111100111111111111111111111111111111111100111111111111111111111111111111111100111111111111111111"));
        levelsList.add(new String("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000003000000000000000000000000000000000003000000000000000000000000000000000000000000000040110000000000000000000000000000000000510000000000011000000000000000000222222000000000015000000000000000000000001000000000015040000000000000020000001220000000022222002002002002000000000010000000000000000000000000000000000012200000000000000000000000000000000000100000000000000000000000000000000000120000000000000000000000000000000000012000000000000000000000000000000000000020606060606060606060606060606060000000222222222222222222222222222222222222"));
        levelsList.add(new String("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011110000000000000000000000000000000040510000000003000000000002000000000222220000000003000000000000000000000000000000000000000000001000002000010000000000001000020000000000000000000000000000000000000002000020000000300000000000000002000000000000000000000000000000000000000200020000000200002000000000000010000000000002000000000000000000001000010000000000000000000000000000000000000010001000000000000000000000000000000000000000000002002000000000000010000001000000000000000000000000000000000000000000010000000000000000000000000000000000000000100000000000000000000000000000000000000000000000"));
        levelsList.add(new String("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011000000000000000000000000000000004051000000000000000000000000000000000051002002002002002002002000200200022222000000000000000000000000000000000000200000000000000000000000000000000000000000000000000000000000000000000000020000000000000000000000000000000000000020020020200200020020002002002000000000000000000000000000000000000000000000000000000000000000000000000020000000000000000000000000000000000000003000000000000000000000000000000200003000000000000000000000000000000000002000200020002002020020200200020000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));

    }

}
