package com.example.peew;

import java.util.ArrayList;

public class GameWorld {

    Player player;

    Levels levels;

    ArrayList<Platform> platforms;
    ArrayList<Ball> balls;
    public GameWorld(){

        player = new Player();
        player.setWidth(25);
        player.setHeight(65);
        platforms = new ArrayList<Platform>();
        balls = new ArrayList<Ball>();

        levels = new Levels(player, platforms, balls);

        loadNextLevel();

    }

    private void loadNextLevel(){

        levels.loadNextLevel();
    }

    public ArrayList<Platform> getPlatforms(){
        return platforms;
    }

    public ArrayList<Ball> getBalls(){
        return balls;
    }

    public Player getPlayer(){

        return player;
    }

    public void update(){


        player.update();
        for(int i=0;i<balls.size();i++) {balls.get(i).update();}
        movingCollision();
        jumpingCollision();
        fallDown();
        ballsCollision();

        if(player.getY()>1050) resetGame();
    }

    private void resetGame(){

        player.setStartingPosition();
    }

    private void fallDown(){

        boolean isCollision = false;
        int id=0;
        for(int i=0;i<platforms.size();i++){

            if(platforms.get(i).isFallCollision((player.getX()+player.getWidth()/2),(player.getY()+player.getHeight()))==true) {isCollision = true;id=i;break;}

        }


        if(isCollision==false && player.canFall()==true) {player.setVy(6);player.setStandingOnPlatform(false);}
        else if(isCollision==true) {player.setVy(0);player.setStandingOnPlatform(true);player.setY(platforms.get(id).getY()-player.getHeight());}
    }

    private void movingCollision(){

        boolean isCollision = false;
        int id=0;
        for(int i=0;i<platforms.size();i++){

            if(platforms.get(i).isMovingCollision((player.getX()+player.getWidth()/2),player.getY(),player.getHeight())==true){isCollision = true;id=i;break;}
        }

        if(isCollision==true) player.setX(player.getX()+(-1)*player.getVx());
    }

    private void jumpingCollision(){

        boolean isCollision = false;

        for(int i=0;i<platforms.size();i++){

            if(platforms.get(i).isJumpingCollision((player.getX()+player.getWidth()/2),(player.getY()))==true) {isCollision = true;break;}

        }
        if(isCollision==true) {player.setVy(6);player.setCanFallTrue();}

    }

    private void ballsCollision(){

        for(int j=0;j<balls.size();j++){

            boolean isCollision = false;
            int id=0;
            Ball ball = balls.get(j);

            for(int i=0;i<platforms.size();i++){

                if(platforms.get(i).isFallCollision((ball.getX()+ball.getWidth()/2),(ball.getY()+ball.getHeight()))==true) {isCollision = true;id=i;break;}
            }

            if(isCollision==false && ball.canFall()==true) {ball.setVy(6);}
            else if(isCollision==true) {ball.setVy(0);ball.setY(platforms.get(id).getY()-ball.getHeight());}

        }


    }

}
