package com.example.peew;

import java.util.ArrayList;

public class CollisionDetector {

    private Player player;
    private ArrayList<Ball> balls;
    private ArrayList<Platform> platforms;

    public CollisionDetector(Player player, ArrayList<Ball> balls, ArrayList<Platform> platforms){


        this.platforms = platforms;
        this.player = player;
        this.balls = balls;


    }

    public void detecteCollision(){

        movingCollision();
        jumpingCollision();
        fallDown(player);
        for(int j=0;j<balls.size();j++){

            fallDown(balls.get(j));

        }

    }

    private void fallDown(GameMovingObject object){

        boolean isCollision = false;
        int platformId=0;
        for(int i=0;i<platforms.size();i++){


            if((object.getX()+object.getWidth()>=platforms.get(i).getX() &&
                    object.getX()<=platforms.get(i).getX()+platforms.get(i).getWidth() &&
                    object.getY()+object.getHeight()>=platforms.get(i).getY() &&
                    object.getY()+object.getHeight()<=platforms.get(i).getY()+40)==true
            ) {isCollision = true;platformId=i;break;}
        }

        if(object==player) playerCollisionUpdate(isCollision, platformId);
        else ballCollisionUpdate(isCollision, object, platformId);

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

    private void ballCollisionUpdate(boolean isCollision, GameMovingObject object, int platformId) {

        if (isCollision == false && object.canFall() == true) {
            object.setVy(6);
        } else if (isCollision == true) {
            object.setVy(0);
            object.setY(platforms.get(platformId).getY() - object.getHeight());
        }

    }


    private void playerCollisionUpdate(boolean isCollision, int platformId){

        if(isCollision==false && player.canFall()==true) {player.setVy(6);player.setStandingOnPlatform(false);}
        else if(isCollision==true) {player.setVy(0);player.setStandingOnPlatform(true);player.setY(platforms.get(platformId).getY()-player.getHeight());}


    }

}
