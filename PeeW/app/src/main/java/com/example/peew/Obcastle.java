package com.example.peew;

public class Obcastle extends GameObject {

    public Obcastle(int x, int y){

        super(x,y);

        this.setWidth(50);
        this.setHeight(50);

    }

    public boolean isObjectTouching(GameObject gameObject){

        if( gameObject.getX()+gameObject.getWidth()>=x && gameObject.getX() <= x+width &&
            gameObject.getY() + gameObject.getHeight() > y &&
            gameObject.getY() + gameObject.getHeight() <= y+height

        ) return true;


        return false;
    }


}
