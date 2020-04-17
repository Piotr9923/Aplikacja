package com.example.peew;

public class Obcastle extends GameObject {

    private int type;

    public Obcastle(int x, int y, int type){

        super(x,y);

        this.setWidth(50);
        this.setHeight(50);

        this.type=type;

    }

    public int getType(){
        return type;
    }

    public boolean isObjectTouching(GameObject gameObject){

        if( gameObject.getX()+gameObject.getWidth()>=x && gameObject.getX() <= x+width &&
            gameObject.getY() + gameObject.getHeight() > y &&
            gameObject.getY() + gameObject.getHeight() <= y+height

        ) return true;


        return false;
    }


}
