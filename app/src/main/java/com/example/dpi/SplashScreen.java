package com.example.dpi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ImageView logo = findViewById(R.id.logoImg);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.transition);
        logo.startAnimation(animation);

        new Thread(new Runnable() {
            @Override
            public void run() {
                work();
                startApp();
                finish();
            }
        }).start();

    }

    private void work(){
        try {
            Thread.sleep(5000);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void startApp(){
        Intent i = new Intent(SplashScreen.this,MainActivity.class);
        startActivity(i);
    }
}
