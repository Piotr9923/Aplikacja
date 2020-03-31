package com.example.peew;

public class Platform extends GameObject{

    public Platform(int x, int y){
        super(x, y);

        width = 50;
        height = 50;

    }

    public boolean isFallCollision(int checkedX, int checkedY){

        if(checkedX+15>=x && checkedX-15<=x+width && checkedY>=y && checkedY<=y+5) return true;

        return false;
    }

    public boolean isMovingCollision(int checkedX, int checkedY, int vx){

        boolean isCollision=false;

        if(((checkedX+15>x && checkedX+15-vx*2<x )
                || (checkedX-15>x+width && checkedX-15+vx*2<x+width)) && checkedY>y+10 ) isCollision = true;

       if(isCollision==true && checkedY-6>y && checkedY-6<= y+height) isCollision=true;
        else isCollision=false;

        return isCollision;

    }

}
