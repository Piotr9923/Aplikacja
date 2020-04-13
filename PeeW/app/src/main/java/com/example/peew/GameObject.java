package com.example.peew;

public abstract class GameObject {

    protected float x,y;
    protected int width,height;

    public GameObject(){

        this.x=0;
        this.y=0;
        this.width=0;
        this.height=0;

    }

    public GameObject(int x,int y){

        this.x=x;
        this.y=y;

    }

    public void setX(float x){

        this.x=x;
    }

    public void setY(float y){

        this.y=y;
    }

    public void setWidth(int width){

        this.width=width;
    }

    public void setHeight(int height){

        this.height=height;
    }


    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

}
