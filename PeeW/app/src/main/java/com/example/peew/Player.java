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
    public void setVy(int vy){
        if(vy<0 && isStandingOnPlatform==true) {
            canFall=false; jumpHeight=y+jumpRating*vy;
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

    public void kick(){

        if(this.x<kickedBall.getX()+kickedBall.getWidth()/2) kickedBall.setVx(4);
        else kickedBall.setVx(-4);
    }
}
