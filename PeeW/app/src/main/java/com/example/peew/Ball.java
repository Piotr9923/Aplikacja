package com.example.peew;

public class Ball extends GameMovingObject {

    private int startX, startY;


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




}
