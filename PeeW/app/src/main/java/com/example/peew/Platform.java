package com.example.peew;

public class Platform extends GameObject{

    private boolean isGrass;

    public Platform(int x, int y, boolean isGrass){
        super(x, y);

        width = 50;
        height = 50;
        this.isGrass = isGrass;

    }

    public boolean getIsGrass(){
        return isGrass;
    }

}

