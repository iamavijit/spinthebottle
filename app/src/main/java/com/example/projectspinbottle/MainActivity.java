package com.example.projectspinbottle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private Button button;
    Random random = new Random();
    private int last ,newp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickme();
            }
        });
    }
    private void clickme(){
        newp = random.nextInt(3600);
        if (last < newp){
            newp=newp+360;
        }
        else{
            last=last+360;
        }
        float pivotX = (float)imageView.getWidth()/2;
        float pivotY = (float)imageView.getHeight()/2;
        Animation rotate = new RotateAnimation(last,newp,pivotX,pivotY);
        rotate.setDuration(2000);
        rotate.setFillAfter(true);
        last=newp;
        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                button.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                button.setEnabled(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        imageView.startAnimation(rotate);
    }
}
