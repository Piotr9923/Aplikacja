package com.example.peew;

public class JumpButton extends MyButton {

    private Player player;

    public JumpButton(int x, int y, int width, int height, Player player, float scaleX, float scaleY){

        super(x, y, width, height, scaleX, scaleY);

        this.player=player;
    }



    @Override
    public void action(){

        if(player.getStandingOnPlatform() == true) {

            player.jump();player.setStandingOnPlatform(false);

        }

    }

}
