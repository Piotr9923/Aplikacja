package com.example.peew;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Locale;

public class MenuActivity extends Activity {

    Button startGameButton, exitGameButton, howToPlay;
    ImageView language;
    Bitmap pl,en;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        pl = BitmapFactory.decodeResource(this.getResources(),R.drawable.pl);
        en = BitmapFactory.decodeResource(this.getResources(),R.drawable.en);


        setContentView(R.layout.activity_main);

        language = (ImageView) findViewById(R.id.language);
        language.setImageBitmap(en);
        language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLanguage();
            }
        });
        updateLanguageImage(language);

        startGameButton = (Button) findViewById(R.id.startGameButton);
        exitGameButton = (Button) findViewById(R.id.exit);
        howToPlay = (Button) findViewById(R.id.how);

        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, GameActivity.class);
                startActivity(intent);
                finish();
            }
        });

        exitGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

        howToPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }


    private void changeLanguage() {

        String lang="";

        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();

        if(Locale.getDefault().getLanguage().equals("pl")) lang="en";
        else lang="pl";

        Locale myLocale = new Locale(lang);
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = getIntent();
        finish();
        startActivity(refresh);
    }

    private void updateLanguageImage(ImageView language){

        Resources res = getResources();
        Configuration conf = res.getConfiguration();

        if(Locale.getDefault().getLanguage().equals("pl")) language.setImageBitmap(en);
        else language.setImageBitmap(pl);

    }

    @Override
    protected void onStart() {
        super.onStart();

        updateLanguageImage(language);

    }
}



