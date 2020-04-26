package com.example.peew;

public class GameMovingObject extends GameObject {

    protected boolean canFall = true;

    protected float vx, vy;


    public GameMovingObject() {

        super();

    }

    public GameMovingObject(int x, int y) {

        super(x, y);

    }

    public boolean canFall() {
        return canFall;
    }

    public void setVx(float vx) {

        this.vx = vx;
    }

    public float getVx() {

        return vx;
    }

    public float getVy() {
        return vy;
    }

    public void setVy(float vy) {
        this.canFall=false;
        this.vy = vy;
    }

    public void setCanFallTrue() {

        this.canFall = true;
    }
}
