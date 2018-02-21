package com.londonappbrewery.magiceightball;

import android.media.Image;
import android.support.v4.widget.ImageViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public int temp = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button askBtn = (Button) findViewById(R.id.askBtn);

        final ImageView ballDisplay = (ImageView) findViewById(R.id.image_eightBall);
        final int[] ballImage = {
                R.drawable.ball1,
                R.drawable.ball2,
                R.drawable.ball3,
                R.drawable.ball4,
                R.drawable.ball5
        };
        askBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                int randomNumber = temp;
                if(temp == -1) {
                    randomNumber = rand.nextInt(4);
                }else{
                    while(temp == randomNumber){
                        randomNumber = rand.nextInt(4);
                    }
                }
                temp=randomNumber;
                ballDisplay.setImageResource(ballImage[randomNumber]);

            }
        });

    }
}
