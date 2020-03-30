package com.example.peew;

public abstract class GameObject {

    protected int x,y,width,height;

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

    public void setX(int x){

        this.x=x;
    }

    public void setY(int y){

        this.y=y;
    }

    public void setWidth(int width){

        this.width=width;
    }

    public void setHeight(int height){

        this.height=height;
    }


    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

}
