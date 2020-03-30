package com.example.peew;

public class Player extends GameObject {

    private int vx,vy;

    public Player(){
        super();

    }


    public void update(){

        x=x+vx;
        y=y+vy;

        if(vy>0) vy=0;

    }

    public void setVx(int vx){
        this.vx=vx;
    }
    public void setVy(int vy){
        this.vy=vy;
    }

}
