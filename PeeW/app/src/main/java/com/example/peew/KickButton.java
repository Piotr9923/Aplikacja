package com.example.peew;

public class KickButton extends MyButton {

    private GameWorld gameWorld;

    public KickButton(int x, int y, int width, int height, GameWorld gameWorld, float scaleX, float scaleY){

        super(x, y, width, height, scaleX, scaleY);

        this.gameWorld=gameWorld;
    }



    @Override
    public void action(){

        gameWorld.getPlayer().kick();

    }

}
