package com.example.peew;

import android.content.Context;
import android.media.MediaPlayer;
import android.provider.MediaStore;

public class SoundPlayer {

    private MediaPlayer backgroundMusic;
    private MediaPlayer collisionMusic;

    public SoundPlayer(Context contex){

        backgroundMusic = MediaPlayer.create(contex,R.raw.background);
        backgroundMusic.setLooping(true);

        collisionMusic = MediaPlayer.create(contex,R.raw.ball);
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
