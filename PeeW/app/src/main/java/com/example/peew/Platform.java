package com.example.peew;

public class Platform extends GameObject{

    public Platform(int x, int y){
        super(x, y);

        width = 50;
        height = 50;

    }

    public boolean isFallCollision(int checkedX, int checkedY){

        if(checkedX+10>=x && checkedX-10<=x+width && checkedY>=y && checkedY<=y+6) return true;

        return false;
    }

    public boolean isMovingCollision(int checkedX, int checkedY, int vx){

        boolean isCollision=false;

        if(((checkedX+20>x && checkedX+20-vx*2<x )
                || (checkedX-20>x+width && checkedX-20+vx*2<x+width)) ) isCollision = true;

       if(isCollision==true && checkedY>y && checkedY<= y+height) isCollision=true;
        else isCollision=false;

        return isCollision;

    }

}
