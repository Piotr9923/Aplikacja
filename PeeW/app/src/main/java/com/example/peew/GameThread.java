package com.example.peew;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GameThread extends Thread {

    private boolean running;
    private GameView gameView;
    private SurfaceHolder surfaceHolder;
    private GameWorld gameWorld;

    public GameThread(GameView gameView,GameWorld gameWorld)  {
        this.gameView = gameView;
        this.surfaceHolder = gameView.getHolder();
        this.gameWorld = gameWorld;

    }

    @Override
    public void run()  {
        long startTime = System.nanoTime();

        while(running)  {
            Canvas canvas= null;
            try {
                canvas = this.surfaceHolder.lockCanvas();

                if(gameWorld.getLevels().getIsFinished()==true) this.stop();


                synchronized (canvas)  {
                    this.gameWorld.update();
                    this.gameView.draw(canvas);
                }
            }catch(Exception e)  {
                // Do nothing.
            } finally {
                if(canvas!= null)  {
                    // Unlock Canvas.
                    this.surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
            long now = System.nanoTime() ;
            // Interval to redraw game
            // (Change nanoseconds to milliseconds)
            long waitTime = (now - startTime)/1000000;

            if(waitTime < 20)  {
                waitTime= 20; // Millisecond.
            }

            try {
                // Sleep.
                this.sleep(waitTime);
            } catch(InterruptedException e)  {

            }
            startTime = System.nanoTime();
        }
    }

    public void setRunning(boolean running)  {
        this.running= running;
    }
}