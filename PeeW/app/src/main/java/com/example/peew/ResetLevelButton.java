package com.example.peew;

public class ResetLevelButton extends MyButton {

    private GameWorld gameWorld;

    public ResetLevelButton(int x, int y, int width, int height, GameWorld gameWorld, float scaleX, float scaleY){

        super(x, y, width, height, scaleX, scaleY);

        this.gameWorld = gameWorld;

    }

    @Override
    protected void action() {

        gameWorld.resetGame();

    }
}
