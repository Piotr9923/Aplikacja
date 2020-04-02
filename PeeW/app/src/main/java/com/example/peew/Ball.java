package com.example.peew;

public class Ball extends GameObject {

    private int startX, startY;
    private int vx,vy;
    private boolean canFall = true;


    public Ball(int x, int y){

        super(x, y);
        this.width = 25;
        this.height = 25;
        this.vx = 0;
        this.vy = 0;
        this.startX = x;
        this.startY = y;
    }

    public void setStartingPosition(){

        this.x = startX;
        this.y = startY;

    }

    public void update() {

        x = x + vx;
        y = y + vy;

        if(canFall==false && vy==0) canFall=true;
    }

    public void setVx(int vx){

        this.vx=vx;
    }

    public void setVy(int vy){

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

    public int getVy(){

        return vy;
    }


}
