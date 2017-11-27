package com.example.gsl.mycustomview;

import android.animation.StateListAnimator;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.Random;

import static java.lang.Thread.sleep;

public class MainActivity extends Activity {


    private Button btn;
    private CustomAnimation cm;
    RelativeLayout rw;
    private String[] animationNames = {"Alpha","Translate","Rotate","Scale"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rw = (RelativeLayout) findViewById(R.id.root_view);
        final Random ran = new Random();


        ScaleAnimation animation = new ScaleAnimation(0,1,0,1);
        animation.setDuration(1000);
        LayoutAnimationController lc = new LayoutAnimationController(animation,0.5f);
        rw.setLayoutAnimation(lc);

        btn = (Button) findViewById(R.id.button);
        Log.d("gongshouli","111========="+btn.getText());
        cm = new CustomAnimation();
        cm.setDuration(1000);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0;i < rw.getChildCount();i++){
                    rw.getChildAt(i).startAnimation(cm);
                }
            }
        });
        cm.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                btn.setClickable(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                int index = ran.nextInt(4);
                btn.setText(animationNames[index]);
                cm.setBtnText(animationNames[index]);
                btn.setClickable(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });



    }

}
