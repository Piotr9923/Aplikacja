package com.example.peew;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.provider.MediaStore;

public class SoundPlayer {

    private MediaPlayer backgroundMusic;
    private MediaPlayer collisionMusic;

    public SoundPlayer(Context contex){

        collisionMusic = MediaPlayer.create(contex,R.raw.ball);
        backgroundMusic = MediaPlayer.create(contex, R.raw.background);

        backgroundMusic.setLooping(true);
        backgroundMusic.start();
    }

    public void playBackgroundMusic(){

        backgroundMusic.start();

    }
    public void stopBackgroundMusic(){

        backgroundMusic.stop();

    }

    public void playCollisionMusic(){

        collisionMusic.start();
    }

}
