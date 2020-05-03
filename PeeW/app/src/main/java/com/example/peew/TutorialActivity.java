package com.example.peew;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TutorialActivity extends Activity {

    private Button closeButton, nextButton, previousButton;
    private ImageView image;
    private int imageId;
    private Bitmap[] tutorialImages;
    private TextView describeTextView;
    private int[] describes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_tutorial);

        imageId = 0;

        image = (ImageView) findViewById(R.id.tutorialImage);
        tutorialImages = new Bitmap[7];
        loadImages();

        describeTextView = (TextView) findViewById(R.id.describe);
        describeTextView.setMovementMethod(new ScrollingMovementMethod());

        describes = new int[7];
        loadDescribes();

        closeButton = (Button) findViewById(R.id.close);
        nextButton = (Button) findViewById(R.id.next);
        previousButton = (Button) findViewById(R.id.previous);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageId++;
                updateView();
            }
        });

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             imageId--;
             updateView();
            }
        });


        updateView();

    }

    private void loadImages(){


        tutorialImages[0] = BitmapFactory.decodeResource(this.getResources(),R.drawable.tutorial0);
        tutorialImages[1] = BitmapFactory.decodeResource(this.getResources(),R.drawable.tutorial1);
        tutorialImages[2] = BitmapFactory.decodeResource(this.getResources(),R.drawable.tutorial2);
        tutorialImages[3] = BitmapFactory.decodeResource(this.getResources(),R.drawable.tutorial3);
        tutorialImages[4] = BitmapFactory.decodeResource(this.getResources(),R.drawable.tutorial4);
        tutorialImages[5] = BitmapFactory.decodeResource(this.getResources(),R.drawable.tutorial5);
        tutorialImages[6] = BitmapFactory.decodeResource(this.getResources(),R.drawable.tutorial6);

    }

    private void loadDescribes(){

        describes[0]=R.string.tutorial0;
        describes[1]=R.string.tutorial1;
        describes[2]=R.string.tutorial2;
        describes[3]=R.string.tutorial3;
        describes[4]=R.string.tutorial4;
        describes[5]=R.string.tutorial5;
        describes[6]=R.string.tutorial6;

    }

    private void updateView(){

        if(imageId<0) imageId=0;
        if(imageId>tutorialImages.length-1) imageId=tutorialImages.length-1;

        image.setImageBitmap(tutorialImages[imageId]);

        describeTextView.setText(describes[imageId]);

        if(imageId==0) previousButton.setVisibility(View.INVISIBLE);
        else previousButton.setVisibility(View.VISIBLE);
        if(imageId==tutorialImages.length-1) nextButton.setVisibility(View.INVISIBLE);
        else nextButton.setVisibility(View.VISIBLE);

        describeTextView.setScrollY(0);

    }

}
