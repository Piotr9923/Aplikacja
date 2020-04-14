package com.example.peew;

import java.util.ArrayList;

public class GameWorld {

    private Player player;

    private Levels levels;

    private ArrayList<Platform> platforms;
    private ArrayList<Ball> balls;
    private ArrayList<Goal> goals;
    private ArrayList<Obcastle> obcastles;

    private CollisionDetector collisionDetector;

    private GameView gameView;

    public GameWorld(GameActivity gameActivity) {

        player = new Player();
        player.setWidth(25);
        player.setHeight(65);
        platforms = new ArrayList<Platform>();
        balls = new ArrayList<Ball>();
        goals = new ArrayList<Goal>();
        obcastles = new ArrayList<Obcastle>();

        levels = new Levels(player, platforms, balls,goals,obcastles,gameActivity);
        loadNextLevel();
        collisionDetector = new CollisionDetector(player, balls, platforms);
    }

    public void setGameView(GameView gameView){

        this.gameView = gameView;

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

    public ArrayList<Obcastle> getObcastles() {
        return obcastles;
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

      checkResetGame();

        if(isLevelWin()==true) levels.loadNextLevel();

        checkCanPlayerKick();
        checkCanPlayerKick();
    }

    private void checkResetGame(){


        if (player.getY() > 1050) resetGame();
        for (int i = 0; i < balls.size(); i++) {
            if (balls.get(i).getY() > 1050) resetGame();
            if (balls.get(i).getX() > 1800 || balls.get(i).getX() + balls.get(i).getHeight() < 0) resetGame();
        }

        for(int o=0;o<obcastles.size();o++){

            if(obcastles.get(o).isObjectTouching(player) == true) resetGame();

            for (int b= 0; b < balls.size(); b++) {
                if(obcastles.get(o).isObjectTouching(balls.get(b)) == true) resetGame();
              }


        }
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

        boolean isBallInGoal = false;
        boolean isLevelWin = true;
        for(int b=0;b<balls.size();b++){
            isBallInGoal=false;

            for(int g=0;g<goals.size();g++){

                if(goals.get(g).isBallInGoal(balls.get(b))==true) isBallInGoal=true;

            }
            balls.get(b).setIsInGoal(isBallInGoal);
            if(isBallInGoal==false) isLevelWin=false;

        }

        return isLevelWin;
    }

    private void resetGame() {

        gameView.offKickView();
        player.setStartingPosition();
        for (int i = 0; i < balls.size(); i++) {
            balls.get(i).setStartingPosition();
            balls.get(i).setVx(0);
            balls.get(i).setVy(0);
        }
    }


}
