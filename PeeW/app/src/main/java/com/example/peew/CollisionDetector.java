package com.example.peew;

import java.util.ArrayList;

public class CollisionDetector {

    private Player player;
    private ArrayList<Ball> balls;
    private ArrayList<Platform> platforms;
    private SoundPlayer soundPlayer;

    public CollisionDetector(Player player, ArrayList<Ball> balls, ArrayList<Platform> platforms, SoundPlayer soundPlayer){


        this.platforms = platforms;
        this.player = player;
        this.balls = balls;
        this.soundPlayer = soundPlayer;

    }

    public void detecteCollision(){


        driveTheBall();
        movingCollision(player,-1);
        jumpingCollision(player);
        fallDownWithBallsCollision(player,-1);
        if(player.getStandingOnPlatform()==false) fallDownWithPlatformsCollision(player,-1);

        for(int j=0;j<balls.size();j++){

            boolean isBallDownCollision=false;

            movingCollision(balls.get(j),j);
            jumpingCollision(balls.get(j));

            isBallDownCollision = fallDownWithBallsCollision(balls.get(j),j);
            if(isBallDownCollision==false) isBallDownCollision= fallDownWithPlayerCollision(balls.get(j));
            if(isBallDownCollision==false) fallDownWithPlatformsCollision(balls.get(j),j);
        }

    }

    private void driveTheBall(){

        for(int i=0;i<balls.size();i++){
            boolean isCollision=false;

            if(     player.getX()+player.getWidth()>=balls.get(i).getX() &&
                    player.getX()<=balls.get(i).getX()+balls.get(i).getWidth()
            ) isCollision=true;

            if(   ((isCollision==true && balls.get(i).getY()>player.getY() &&
                    balls.get(i).getY()<player.getY()+player.getHeight()))||
                    ( (isCollision==true && balls.get(i).getY()+balls.get(i).getHeight()>player.getY() &&
                            balls.get(i).getY()+balls.get(i).getHeight()<player.getY()+player.getHeight()))
            ) {isCollision=true;}
            else isCollision=false;

            if(isCollision==true && player.getVx()==0) balls.get(i).setX(balls.get(i).getX()-balls.get(i).getVx());
            if(isCollision==true){balls.get(i).setX(balls.get(i).getX()+player.getVx());balls.get(i).setVx(0);balls.get(i).setVy(0);}
            if(isCollision==true && movingCollision(balls.get(i),i)==true){balls.get(i).setX(balls.get(i).getX()-player.getVx());player.setX(player.getX()-player.getVx());}

        }

    }

    private void fallDownWithPlatformsCollision(GameMovingObject object, int ballId){

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
            else if (isCollision == true&&balls.get(ballId).isPassKick()==true) { object.setVy(0);object.setY(platforms.get(platformId).getY() - object.getHeight()); }
            else if (isCollision == true) { object.setVy(0);object.setVx(0);object.setY(platforms.get(platformId).getY() - object.getHeight()); }

        }
   }

    private boolean fallDownWithBallsCollision(GameMovingObject object, int id){

        boolean isCollision = false;
        int ballId=0;
        for(int i=0;i<balls.size();i++){


            if((    id!=i &&
                    object.getX()+object.getWidth()>balls.get(i).getX() &&
                    object.getX()<balls.get(i).getX()+balls.get(i).getWidth() &&
                    object.getY()+object.getHeight()>=balls.get(i).getY() &&
                    object.getY()+object.getHeight()<=balls.get(i).getY()+15)==true
            ) {isCollision = true;ballId=i;break;}
        }

        if(object==player) {
            if(isCollision==false && player.canFall()==true) {player.setVy(6);player.setStandingOnPlatform(false);}
            else if(isCollision==true) {;player.setVy(0);player.setStandingOnPlatform(true);player.setY(balls.get(ballId).getY()-player.getHeight());balls.get(ballId).setVy(6);}
        }
        else {
            if (isCollision == false && object.canFall() == true) {object.setVy(6);}
            else if (isCollision == true) { object.setVy(0);object.setY(balls.get(ballId).getY() - object.getHeight()); }
        }
        return isCollision;
    }

    private boolean fallDownWithPlayerCollision(Ball ball){

        boolean isCollision = false;


            if(  ball.getX()+ball.getWidth()>player.getX() &&
                    ball.getX()<player.getX()+player.getWidth() &&
                    ball.getY()+ball.getHeight()>=player.getY() &&
                    ball.getY()+ball.getHeight()<=player.getY()+15
            ) {isCollision = true;}


            if (isCollision == false && ball.canFall() == true) {ball.setVy(6);}
            else if (isCollision == true) { ball.setVy(0);ball.setY(player.getY() - ball.getHeight()); }

            return isCollision;
    }


    private boolean movingCollision(GameMovingObject object, int ballId){

        boolean isCollision = false;
        int id=0;

        for(int i=0;i<platforms.size();i++){


            if(     (object.getX()+object.getWidth()>platforms.get(i).getX() ) &&
                    (object.getX()<platforms.get(i).getX()+platforms.get(i).getWidth() )
            ) isCollision = true;

            if(     (isCollision==true && object.getY()>platforms.get(i).getY() && object.getY()<= platforms.get(i).getY()+platforms.get(i).getHeight()) ||
                    (isCollision==true && object.getY() + object.getHeight()>platforms.get(i).getY() && object.getY() + object.getHeight()<= platforms.get(i).getY()+platforms.get(i).getHeight()) ||
                    (isCollision==true && object.getY() + object.getHeight()/2>platforms.get(i).getY() && object.getY() + object.getHeight()/2<= platforms.get(i).getY()+platforms.get(i).getHeight())
            ) {isCollision=true;id=i;break;}
            else isCollision=false;

        }

        if(object==player) {
            if (isCollision == true) player.setX(player.getX() + (-1) * player.getVx());
        }else{
            if(isCollision == true && balls.get(ballId).getIsInGoal() == true ) {object.setX(object.getX() + (-1) * object.getVx());object.setVx(0);object.setVy(6);}
            else if (isCollision == true) {object.setX(object.getX() + (-1) * object.getVx());object.setVx(-object.getVx());}

            if(isCollision==true) soundPlayer.playCollisionMusic();
        }

        return isCollision;
    }

    private void jumpingCollision(GameMovingObject object ){

        boolean isCollision = false;

        for(int i=0;i<platforms.size();i++){

            if (    object.getX() + object.getWidth() > platforms.get(i).getX() &&
                    object.getX()  < platforms.get(i).getX() + platforms.get(i).getWidth() &&
                    object.getY() <= platforms.get(i).getY() + platforms.get(i).getHeight() &&
                    object.getY() >= platforms.get(i).getY()
            ){isCollision=true; break;}

        }

        if(isCollision==true && object.getVy()<0) {object.setVx(-object.getVx());}
        if(isCollision==true && object.getVy()<0) {object.setVy(6);object.setCanFallTrue();}

    }


}
