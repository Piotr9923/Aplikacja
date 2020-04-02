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

    public boolean isFallCollision(int checkedX, int checkedY){

        if(checkedX+15>=x && checkedX-15<=x+width && checkedY>=y && checkedY<=y+6) return true;

        return false;
    }

    public boolean isMovingCollision(int checkedX, int checkedY, int playerHeight){

        boolean isCollision=false;

        if((checkedX+15>=x )
                && (checkedX-15<=x+width ) ) isCollision = true;

       if((isCollision==true && checkedY>y && checkedY<= y+height) || (isCollision==true && checkedY + playerHeight>y && checkedY + playerHeight<= y+height) || (isCollision==true && checkedY + playerHeight/2>y && checkedY + playerHeight/2<= y+height)) isCollision=true;
       else isCollision=false;

        return isCollision;

    }

    public boolean isJumpingCollision(int checkedX, int checkedY) {

        if (checkedX + 15 >= x && checkedX - 15 <= x + width && checkedY <= y + width && checkedY >= y + width -6)
            return true;

        return false;
    }
}

