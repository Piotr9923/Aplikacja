package com.example.peew;

import java.util.ArrayList;

public class GameWorld {

    Player player;

    Levels levels;

    ArrayList<Platform> platforms;

    public GameWorld(){

        player = new Player();
        player.setWidth(30);
        player.setHeight(80);
        platforms = new ArrayList<Platform>();

        levels = new Levels(player, platforms);

        loadNextLevel();

    }

    private void loadNextLevel(){

        levels.loadNextLevel();
    }

    public ArrayList<Platform> getPlatforms(){
        return platforms;
    }

    public Player getPlayer(){

        return player;
    }

    public void update(){


        player.update();

        movingCollision();
        jumpingCollision();
        fallDown();
        if(player.getY()>1050) resetGame();
    }

    private void resetGame(){

        player.setStartingCoordinate();
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

}
