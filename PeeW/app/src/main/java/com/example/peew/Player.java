package com.example.peew;

public class Player extends GameObject {

    private int vx,vy;
    private int jumpHeight;
    private boolean canFall = true;
    private int jumpRating;

    public Player(){
        super();
        jumpRating=15;
    }


    public void update(){

        x=x+vx;
        y=y+vy;

        if(canFall==false && y<jumpHeight) canFall=true;

    }

    public void setVx(int vx){
        this.vx=vx;
    }

    public void setVy(int vy){
        if(vy<0 && this.vy==0) {canFall=false; jumpHeight=y+jumpRating*vy;}

        this.vy=vy;
    }

    public boolean canFall(){
        return canFall;
    }

}
