package com.example.peew;

public class KickButton extends MyButton {

    private GameWorld gameWorld;
    private boolean isKicked;

    public KickButton(int x, int y, int width, int height, GameWorld gameWorld, float scaleX, float scaleY){

        super(x, y, width, height, scaleX, scaleY);

        this.gameWorld=gameWorld;
        isKicked = false;
    }

    public boolean getIsKicked(){
        return isKicked;
    }

    public void setIsKickedFalse(){
        this.isKicked = false;
    }


    @Override
    public void action(){

        if(isKicked == true) isKicked=false;
        else isKicked = true;
    }


}
