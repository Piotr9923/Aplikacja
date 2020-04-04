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

        movingCollision(player);
        jumpingCollision(player);
        fallDown(player);

        for(int j=0;j<balls.size();j++){

            movingCollision(balls.get(j));
            jumpingCollision(balls.get(j));
            fallDown(balls.get(j));

        }

    }

    private void fallDown(GameMovingObject object){

        boolean isCollision = false;
        int platformId=0;
        for(int i=0;i<platforms.size();i++){


            if((    object.getX()+object.getWidth()>platforms.get(i).getX() &&
                    object.getX()<platforms.get(i).getX()+platforms.get(i).getWidth() &&
                    object.getY()+object.getHeight()>=platforms.get(i).getY() &&
                    object.getY()+object.getHeight()<=platforms.get(i).getY()+40)==true
            ) {isCollision = true;platformId=i;break;}
        }

        if(object==player) {
            if(isCollision==false && player.canFall()==true) {player.setVy(6);player.setStandingOnPlatform(false);}
            else if(isCollision==true) {player.setVy(0);player.setStandingOnPlatform(true);player.setY(platforms.get(platformId).getY()-player.getHeight());}
        }
        else {
            if (isCollision == false && object.canFall() == true) {object.setVy(6);}
            else if (isCollision == true) { object.setVy(0);object.setY(platforms.get(platformId).getY() - object.getHeight()); }
        }
   }

    private void movingCollision(GameMovingObject object){

        boolean isCollision = false;
        int id=0;

        for(int i=0;i<platforms.size();i++){

            if(     (object.getX()+object.getWidth()>=platforms.get(i).getX() ) &&
                    (object.getX()<=platforms.get(i).getX()+platforms.get(i).getWidth() )
            ) isCollision = true;

            if(     (isCollision==true && object.getY()>platforms.get(i).getY() && object.getY()<= platforms.get(i).getY()+platforms.get(i).getHeight()) ||
                    (isCollision==true && object.getY() + object.getHeight()>platforms.get(i).getY() && object.getY() + object.getHeight()<= platforms.get(i).getY()+platforms.get(i).getHeight()) ||
                    (isCollision==true && object.getY() + object.getHeight()/2>platforms.get(i).getY() && object.getY() + object.getHeight()/2<= platforms.get(i).getY()+platforms.get(i).getHeight())
            ) {isCollision=true;break;}
            else isCollision=false;

        }

        if(object==player) {
            if (isCollision == true) player.setX(player.getX() + (-1) * player.getVx());
        }else{

            if (isCollision == true) object.setX(object.getX() + (-1) * object.getVx());
        }
    }

    private void jumpingCollision(GameMovingObject object){

        boolean isCollision = false;

        for(int i=0;i<platforms.size();i++){

            if (    object.getX() + object.getWidth() >= platforms.get(i).getX() &&
                    object.getX()  <= platforms.get(i).getX() + platforms.get(i).getWidth() &&
                    object.getY() <= platforms.get(i).getY() + platforms.get(i).getHeight() &&
                    object.getY() >= platforms.get(i).getY() + platforms.get(i).getHeight() - 10
            ){isCollision=true; break;}

        }

        if(isCollision==true) {object.setVy(6);object.setCanFallTrue();}

    }


}
