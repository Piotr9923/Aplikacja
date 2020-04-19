package com.example.peew;

public class Player extends GameMovingObject {

    private int jumpHeight;
    private int jumpRating;
    private boolean isStandingOnPlatform = true;
    private int startX, startY;
    private int maxVx;
    private int maxVy;
    private boolean canKick;
    private Ball kickedBall;

    public Player(){
        super();
        jumpRating=20;
        maxVx=6;
        maxVy=-6;
        canKick =false;
    }

    public void setCanKick(boolean canKick){

        this.canKick = canKick;
    }

    public void setKickedBall(Ball ball){

        this.kickedBall = ball;

    }

    public boolean getCanKick(){

        return canKick;

    }

    public void update(){

        x=x+vx;
        y=y+vy;

        if(canFall==false && y<jumpHeight) canFall=true;
        if(canFall==false && vy==0) canFall=true;
    }

    @Override
    public void setVy(float vy){
        if(vy<0 && isStandingOnPlatform==true) {
            canFall=false;
            jumpHeight= (int) (y+jumpRating*vy);
        }

        this.vy=vy;
    }




    public void setStandingOnPlatform(boolean isStandingOnPlatform){
        this.isStandingOnPlatform=isStandingOnPlatform;
    }

    public boolean getStandingOnPlatform(){

        return isStandingOnPlatform;
    }

    public void setStartingPosition(){

        this.x = startX;
        this.y = startY;
        this.vy = 6;
        this.canFall=true;
    }

    public void setStartingCoordinate(int x, int y){

        this.startX = x;
        this.startY = y;

    }

    public void moveRight(){
        this.vx=maxVx;
    }

    public void moveLeft(){
        this.vx=-maxVx;
    }

    public void jump(){
        this.setVy(maxVy);
    }

    public void kick(float kickedX, float kickedY){

        float ballVx;
        float ballVy;

        if(kickedY<25) {ballVy=0;ballVx=6;}
        else if(kickedX<25){ballVx=0;ballVy=6;}
        else {
            float min= kickedX;
            if (kickedY < kickedX) min = kickedY;

            ballVx = kickedX / min;
            ballVy = kickedY / min;

            float fasterV=ballVx;
            if(ballVy>ballVx) fasterV=ballVy;

            if(ballVx<6 && ballVy<6){

                ballVx=ballVx*6/fasterV;
                ballVy=ballVy*6/fasterV;

            }

        }


        if(ballVy>10) ballVy=10;
        if(ballVx>10) ballVx=10;


        if(this.x>kickedBall.getX()+kickedBall.getWidth()/2) ballVx=-ballVx;

        boolean passKick=false;
        if(ballVy==0) passKick=true;

        kickedBall.setVx(ballVx);
        kickedBall.setVy(-ballVy);

        float distance = kickedX*kickedX + kickedY*kickedY;
        distance= (float) Math.sqrt(distance);

        kickedBall.kick(distance,passKick);

    }
}
