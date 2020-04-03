package com.example.peew;

public class GameMovingObject extends GameObject {

    boolean canFall = true;

    protected int vx,vy;


    public GameMovingObject(){

        super();

    }

    public GameMovingObject(int x, int y){

        super(x,y);

    }

    public boolean canFall(){
        return canFall;
    }

    public void setVx(int vx){

        this.vx=vx;
    }

    public int getVx(){

        return vx;
    }

    public int getVy(){
        return vy;
    }

    public void setVy(int vy){

        this.vy=vy;
    }

    public void setCanFallTrue(){

        this.canFall = true;
    }
}
