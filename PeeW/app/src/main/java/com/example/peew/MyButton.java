package com.example.peew;

public class MyButton {

    private int x, y, width, height;
    private float scaleX, scaleY;

    public MyButton(int x, int y, int width, int height, float scaleX, float scaleY){

        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.scaleX=scaleX;
        this.scaleY=scaleY;

    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }


    public void isClicked(float touchedX, float touchedY){

        if(touchedX>x*scaleX && touchedX<(x+width)*scaleX && touchedY>y*scaleY && touchedY<(y+height)*scaleY){

            this.action();

        }

    }

    protected void action(){


    }

}
