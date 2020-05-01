package com.example.peew;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class GameActivity extends Activity {

    private GameView gameView;
    private GameWorld gameWorld;
    private SoundPlayer soundPlayer;
    private GameThread gameThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        soundPlayer = new SoundPlayer(this.getApplicationContext());
        soundPlayer.playBackgroundMusic();

        gameWorld = new GameWorld(this, soundPlayer);
        gameView = new GameView(this, gameWorld);
        gameWorld.setGameView(gameView);

        setContentView(gameView);

        this.gameThread = new GameThread(gameView, gameWorld, gameView.getHolder());
        this.gameThread.setRunning(true);
        this.gameThread.start();



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        soundPlayer.stopBackgroundMusic();
    }
}
