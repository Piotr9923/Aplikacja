package com.example.peew;

import java.util.ArrayList;

public class Levels {

    private int levelId;
    private Player player;

    private ArrayList<Platform> platforms;
    private ArrayList<String> levelsList;
    private ArrayList<Ball> balls;


    public Levels(Player player, ArrayList<Platform> platforms, ArrayList<Ball> balls) {

        levelId = 0;
        this.player = player;
        levelsList = new ArrayList<String>();
        this.platforms = platforms;
        this.balls = balls;
        createLevels();
    }

    public void loadNextLevel() {

        platforms.removeAll(platforms);
        balls.removeAll(balls);

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
                }

            }

        }

        levelId++;
    }

    private void createLevels() {

        levelsList.add(new String("000000000000000000000000000000000000000020000000000000000000000000000000000000000000000000300000000000000000000200000000100000300000000000000000000000222222222222222100000000000000000000000000000000000100000000000000002240000000000000000100000000000000001000002111110000000100000000000000000220000000000222200100000000000000000010000000000000020100000000000000000002000000020000000100000000000000022222222222222222222100011122222000000000000000000000000100000000000000000000000000000000000100000000000000000000000000000000000100000000000000000000000000000000000100000000000000000000000000000000000100000000000000000000000000000000000100000000000000000000000000000000000100000000000000000000000000000000000100000000000000"));

    }


}
