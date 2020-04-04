package com.example.peew;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private GameWorld gameWorld;
    private Player player;
    private GameThread gameThread;

    private MyButton leftButton, rightButton, jumpButton;

    private Bitmap leftButtonImage, rightButtonImage, jumpButtonImage;
    private Bitmap playerImage;
    private Bitmap ballImage;

    private int screenWidth, screenHeight;
    private float scaleX, scaleY;

    private Bitmap platformImage, platformWithGrassImage;

    public GameView(Context context, GameWorld gameWorld) {
        super(context);

        this.gameWorld = gameWorld;

        player = gameWorld.getPlayer();

        screenWidth = getResources().getDisplayMetrics().widthPixels;
        screenHeight = getResources().getDisplayMetrics().heightPixels;

        scaleX = (float) screenWidth / 1794;
        scaleY = (float) screenHeight / 1000;

        createImages();
        createButtons();

        this.setFocusable(true);

        this.getHolder().addCallback(this);

    }

    private void createImages() {

        leftButtonImage = BitmapFactory.decodeResource(this.getResources(), R.drawable.leftbutton);
        leftButtonImage = Bitmap.createScaledBitmap(leftButtonImage, 170, 170, true);

        rightButtonImage = BitmapFactory.decodeResource(this.getResources(), R.drawable.rightbutton);
        rightButtonImage = Bitmap.createScaledBitmap(rightButtonImage, 170, 170, true);

        jumpButtonImage = BitmapFactory.decodeResource(this.getResources(), R.drawable.jumpbutton);
        jumpButtonImage = Bitmap.createScaledBitmap(jumpButtonImage, 170, 170, true);

        playerImage = BitmapFactory.decodeResource(this.getResources(), R.drawable.player);
        playerImage = Bitmap.createScaledBitmap(playerImage, player.getWidth(), player.getHeight(), true);

        ballImage = BitmapFactory.decodeResource(this.getResources(), R.drawable.ball);
        ballImage = Bitmap.createScaledBitmap(ballImage, 25, 25, true);

        platformImage = BitmapFactory.decodeResource(this.getResources(), R.drawable.platform);
        platformImage = Bitmap.createScaledBitmap(platformImage, 50, 50, true);

        platformWithGrassImage = BitmapFactory.decodeResource(this.getResources(), R.drawable.platformwithgrass);
        platformWithGrassImage = Bitmap.createScaledBitmap(platformWithGrassImage, 50, 50, true);
    }

    private void createButtons() {

        leftButton = new MyButton(90, 800, leftButtonImage.getWidth(), leftButtonImage.getHeight(), player, true, scaleX, scaleY);
        rightButton = new MyButton(350, 800, rightButtonImage.getWidth(), rightButtonImage.getHeight(), player, true, scaleX, scaleY);
        jumpButton = new MyButton(1500, 800, jumpButtonImage.getWidth(), jumpButtonImage.getHeight(), player, false, scaleX, scaleY);


        leftButton.setLeftDirectory();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.save();

        canvas.scale(scaleX, scaleY);

        canvas.drawColor(Color.WHITE);

        canvas.drawBitmap(playerImage, player.getX(), player.getY(), null);

        drawPlatformsImages(canvas);

        drawBalls(canvas);
        canvas.drawBitmap(leftButtonImage, leftButton.getX(), leftButton.getY(), null);
        canvas.drawBitmap(rightButtonImage, rightButton.getX(), rightButton.getY(), null);
        canvas.drawBitmap(jumpButtonImage, jumpButton.getX(), jumpButton.getY(), null);

        canvas.restore();
    }

    private void drawPlatformsImages(Canvas canvas) {

        for (int i = 0; i < gameWorld.getPlatforms().size(); i++) {

            int platformX = gameWorld.getPlatforms().get(i).getX();
            int platformY = gameWorld.getPlatforms().get(i).getY();
            boolean isGrass = gameWorld.getPlatforms().get(i).getIsGrass();

            if (isGrass == true)
                canvas.drawBitmap(platformWithGrassImage, platformX, platformY, null);
            else canvas.drawBitmap(platformImage, platformX, platformY, null);
        }

    }

    private void drawBalls(Canvas canvas) {

        for (int i = 0; i < gameWorld.getBalls().size(); i++) {

            int ballX = gameWorld.getBalls().get(i).getX();
            int ballY = gameWorld.getBalls().get(i).getY();

            canvas.drawBitmap(ballImage, ballX, ballY, null);
        }

    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        this.gameThread = new GameThread(this, gameWorld, holder);
        this.gameThread.setRunning(true);
        this.gameThread.start();

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float clickedX = event.getX(0);
        float clickedY = event.getY(0);

        float clickedX1 = 0, clickedY1 = 0;

        if (event.getPointerCount() > 1) {
            clickedX1 = event.getX(1);
            clickedY1 = event.getY(1);


            leftButton.isClicked(clickedX1, clickedY1);
            rightButton.isClicked(clickedX1, clickedY1);
            jumpButton.isClicked(clickedX1, clickedY1);
        }

        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            leftButton.isClicked(clickedX, clickedY);
            rightButton.isClicked(clickedX, clickedY);
            jumpButton.isClicked(clickedX, clickedY);

        }


        if (event.getAction() == MotionEvent.ACTION_UP) {

            player.setVx(0);

        }

        return true;
    }
}
