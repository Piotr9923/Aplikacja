package com.example.peew;

public class MovingButton extends MyButton {

    private Player player;
    private boolean isLeft;

    public MovingButton(int x, int y, int width, int height, Player player, boolean isLeft, float scaleX, float scaleY){

        super(x, y, width, height, scaleX, scaleY);

        this.player=player;
        this.isLeft=isLeft;
    }


    @Override
    public void action(){

        if(isLeft == true) player.moveLeft();
        else player.moveRight();

    }

}
