package com.example.peew;

public class Ball extends GameMovingObject {

    private int startX, startY;
    private boolean isInGoal;
    private float range;
    private boolean isKicked;
    private boolean passKick;

    public Ball(int x, int y){

        super(x, y);
        this.width = 25;
        this.height = 25;
        this.vx = 0;
        this.vy = 0;
        this.startX = x;
        this.startY = y;
        this.isInGoal = false;
        this.isKicked = false;
        passKick = false;
    }

    public void setStartingPosition(){

        this.x = startX;
        this.y = startY;

    }

    public void kick(float distance,boolean passKick){

        this.range = distance;
        this.isKicked = true;
        this.passKick=passKick;
    }

    public boolean isPassKick(){
        return passKick;
    }

    public void setIsInGoal(boolean isInGoal){
        this.isInGoal = isInGoal;
    }

    public boolean getIsInGoal(){
        return  isInGoal;
    }

    public void setIsKickedFalse(){
        this.isKicked=false;
    }

    public void update() {

          if(isKicked==true)  {range = range - Math.abs(vx);}
          if(range<0 && isKicked==true) {vy=-vy;isKicked=false;}
          x = x + vx;
          y = y + vy;

          if(canFall==false && vy==0) {canFall=true;isKicked=false;}
    }


    @Override
    public void setVy(float vy) {
        isKicked=false;

        super.setVy(vy);
    }



}
