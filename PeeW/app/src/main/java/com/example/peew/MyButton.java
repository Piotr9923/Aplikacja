package com.example.peew;

public class MyButton {

    private int x, y, width, height;
    private Player player;
    private boolean isMovingButtoon;
    private float scaleX, scaleY;
    private int vx=6,vy=-6;

    public MyButton(int x, int y, int width, int height, Player player, boolean isMovingButton, float scaleX, float scaleY){

        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.player=player;
        this.isMovingButtoon=isMovingButton;
        this.scaleX=scaleX;
        this.scaleY=scaleY;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public void setLeftDirectory(){

        vx=vx*(-1);

    }

    public void isClicked(float touchedX, float touchedY){

        if(touchedX>x*scaleX && touchedX<(x+width)*scaleX && touchedY>y*scaleY && touchedY<(y+height)*scaleY){

            if(isMovingButtoon == true) player.setVx(vx);
            else player.setVy(vy);

        }

    }

}
