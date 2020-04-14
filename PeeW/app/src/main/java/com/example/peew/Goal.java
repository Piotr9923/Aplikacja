package com.example.peew;

import java.util.ArrayList;

public class Goal extends GameObject {

    public Goal(int x, int y){
        super(x,y);

        this.width = 50;
        this.height = 50;

    }

    public boolean isBallInGoal(Ball ball){

        if(     ball.getX()>=x && ball.getX()+ball.getWidth()<x+width &&
                ball.getY() >=y && ball.getY() <= y + height
        ) return true;

        return false;

    }



}
