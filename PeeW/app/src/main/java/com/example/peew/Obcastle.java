package com.example.peew;

public class Obcastle extends GameMovingObject {

    private int type;
    private int xMin,xMax,yMin,yMax;
    private int stop;
    public Obcastle(int x, int y, int type){

        super(x,y);

        this.setWidth(50);
        this.setHeight(50);

        this.vx=0;
        this.vy=0;

        this.xMin=x;
        this.xMax=x;
        this.yMin=y;
        this.yMax=y;

        this.stop=5;

        this.type=type;

    }
    public Obcastle(int x, int y, int type, boolean moving){

        super(x,y);

        this.setWidth(50);
        this.setHeight(50);

        this.vx=0;
        this.vy=0;

        if(type == 1)vy=2;
        else if(type==3) vy=-2;
        else if(type==2) vx=-2;
        else vx=2;

        this.xMin=x;
        this.xMax=x;
        this.yMin=y;
        this.yMax=y;

        this.type=type;

        if(moving == true) setMoving();

    }

    private void setMoving(){

        if(type == 1) yMax=yMax+50;
        else  if(type ==2) xMin=xMin-50;
        else  if(type ==3) yMin=yMax-50;
        else xMax=xMax+50;
    }

    public void update(){

        if(stop==70) {
            if(type==1 || type==3) {


                y = y + vy;

                if (y <= yMin || y >= yMax) {
                    vy = -vy;
                    stop=0;
                }

                if (y >= yMax) y = yMax;
                else if (y <= yMin) y = yMin;

            }
            else{

                x = x + vx;

                if (x <= xMin || x >= xMax) {
                    vx = -vx;
                    stop=0;
                }

                if (x >= xMax) x = xMax;
                else if (x <= xMin) x = xMin;
            }
        }
        else stop++;
    }

    public int getType(){
        return type;
    }

    public boolean isObjectTouching(GameObject gameObject){

        if( gameObject.getX() < x+width && gameObject.getX()  + gameObject.getWidth() > x &&
            gameObject.getY() < y + height &&
            gameObject.getY() + gameObject.getHeight() > y
        ) return true;

        return false;
    }


}
