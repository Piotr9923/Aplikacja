package com.example.peew;

public class Platform extends GameObject{

    public Platform(int x, int y){
        super(x, y);

        width = 50;
        height = 50;

    }

    public boolean isCollision(int checkedX, int checkedY){

        if(checkedX+25>=x && checkedX-25<=x+width && checkedY>=y && checkedY<=y+height) return true;

        return false;
    }


}
