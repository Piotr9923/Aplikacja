package com.example.peew;

import java.util.ArrayList;

public class GameWorld {

    Player player;

    Levels levels;

    ArrayList<Platform> platforms;
    ArrayList<Ball> balls;

    CollisionDetector collisionDetector;

    public GameWorld() {

        player = new Player();
        player.setWidth(25);
        player.setHeight(65);
        platforms = new ArrayList<Platform>();
        balls = new ArrayList<Ball>();

        levels = new Levels(player, platforms, balls);
        loadNextLevel();
        collisionDetector = new CollisionDetector(player, balls, platforms);
    }

    private void loadNextLevel() {

        levels.loadNextLevel();
    }

    public ArrayList<Platform> getPlatforms() {
        return platforms;
    }

    public ArrayList<Ball> getBalls() {
        return balls;
    }

    public Player getPlayer() {

        return player;
    }

    public void update() {


        player.update();
        for (int i = 0; i < balls.size(); i++) {
            balls.get(i).update();
        }

        collisionDetector.detecteCollision();

        if (player.getY() > 1050) resetGame();
        for (int i = 0; i < balls.size(); i++) {
            if (balls.get(i).getY() > 1050) resetGame();
        }
    }

    private void resetGame() {

        player.setStartingPosition();
        for (int i = 0; i < balls.size(); i++) {
            balls.get(i).setStartingPosition();
        }
    }


}
