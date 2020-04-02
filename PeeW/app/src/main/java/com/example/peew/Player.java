package com.example.peew;

public class Player extends GameObject {

    private int vx,vy;
    private int jumpHeight;
    private boolean canFall = true;
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

    public void setVx(int vx){
        this.vx=vx;
    }

    public void setVy(int vy){
        if(vy<0 && isStandingOnPlatform==true) {canFall=false; jumpHeight=y+jumpRating*vy;}

        this.vy=vy;
    }

    public boolean canFall(){
        return canFall;
    }

    public void setCanFallTrue(){

        this.canFall = true;
    }
    public int getVx(){
        return vx;
    }

    public int getVy(){ return vy; }

    public void setStandingOnPlatform(boolean isStandingOnPlatform){
        this.isStandingOnPlatform=isStandingOnPlatform;
    }

    public boolean getStandingOnPlatform(){
        return isStandingOnPlatform;
    }

    public void setStartingCoordinate(){

        this.x = startX;
        this.y = startY;
    }

    public void setStartingCoordinate(int x, int y){

        this.startX = x;
        this.startY = y;

    }
}
