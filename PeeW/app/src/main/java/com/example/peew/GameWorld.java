package com.example.peew;

import java.util.ArrayList;

public class GameWorld {

    Player player;

    Levels levels;

    ArrayList<Platform> platforms;
    ArrayList<Ball> balls;
    ArrayList<Goal> goals;

    CollisionDetector collisionDetector;

    public GameWorld(GameActivity gameActivity) {

        player = new Player();
        player.setWidth(25);
        player.setHeight(65);
        platforms = new ArrayList<Platform>();
        balls = new ArrayList<Ball>();
        goals = new ArrayList<Goal>();

        levels = new Levels(player, platforms, balls,goals,gameActivity);
        loadNextLevel();
        collisionDetector = new CollisionDetector(player, balls, platforms);
    }

    public Levels getLevels(){
        return levels;
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

    public ArrayList<Goal> getGoals() {
        return goals;
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
            if (balls.get(i).getX() > 1800 || balls.get(i).getX() + balls.get(i).getHeight() < 0) resetGame();
        }

        if(isLevelWin()==true) levels.loadNextLevel();

        checkCanPlayerKick();
        checkCanPlayerKick();
    }

    private void checkCanPlayerKick(){

        boolean isBallNear=false;
        for(int i=0;i<balls.size();i++){

            if(     player.getX()+player.getWidth()+10>=balls.get(i).getX() &&
                    player.getX()-10<=balls.get(i).getX()+balls.get(i).getWidth() &&
                    player.getStandingOnPlatform()==true &&
                    player.getY()+player.getHeight() == balls.get(i).getY()+balls.get(i).getHeight()
            ) {isBallNear=true;player.setKickedBall(balls.get(i));break;}
        }
        if(isBallNear==true) player.setCanKick(true);
        else player.setCanKick(false);

    }

    private boolean isLevelWin(){

        boolean isBallInGoal=false;

        for(int b=0;b<balls.size();b++){
            isBallInGoal=false;

            for(int g=0;g<goals.size();g++){

                if(goals.get(g).isInGoal(balls.get(b))==true) isBallInGoal=true;

            }

            if(isBallInGoal==false) return false;

        }

        return true;
    }

    private void resetGame() {

        player.setStartingPosition();
        for (int i = 0; i < balls.size(); i++) {
            balls.get(i).setStartingPosition();
            balls.get(i).setVx(0);
            balls.get(i).setVy(0);
        }
    }


}
