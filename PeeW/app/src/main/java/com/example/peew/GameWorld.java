package com.example.peew;

import java.util.ArrayList;

public class GameWorld {

    Player player;

    Levels levels;

    ArrayList<Platform> platforms;

    public GameWorld(){

        player = new Player();
        player.setWidth(50);
        player.setHeight(100);
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

        fallDown();

        if(player.getY()>1000) {player.setX(0);player.setY(0);}
    }

    private void fallDown(){

        boolean isCollision = false;

        for(int i=0;i<platforms.size();i++){

            if(platforms.get(i).isCollision((player.getX()+player.getHeight()/2),(player.getY()+player.getHeight())
            )==true) {isCollision = true;}
        }


        if(isCollision==false && player.canFall()==true) player.setVy(6);
        else if(isCollision==true) player.setVy(0);
    }

}
