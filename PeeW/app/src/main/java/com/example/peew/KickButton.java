package com.example.peew;

public class KickButton extends MyButton {

    private boolean isClicked;

    public KickButton(int x, int y, int width, int height, float scaleX, float scaleY){

        super(x, y, width, height, scaleX, scaleY);

        isClicked = false;
    }

    public boolean getIsKicked(){
        return isClicked;
    }

    public void setIsKickedFalse(){
        this.isClicked = false;
    }


    @Override
    public void action(){

        if(isClicked == true) isClicked =false;
        else isClicked = true;
    }


}
