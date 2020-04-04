package com.example.peew;

public class Player extends GameMovingObject {

    private int jumpHeight;
    private int jumpRating;
    private boolean isStandingOnPlatform = true;
    private int startX, startY;

    public Player(){
        super();
        jumpRating=20;
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
}
