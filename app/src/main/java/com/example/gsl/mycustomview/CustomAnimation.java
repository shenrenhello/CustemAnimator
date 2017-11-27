package com.example.gsl.mycustomview;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by dell on 2017/11/24.
 */

public class CustomAnimation extends Animation {
    private String btnText = "";

    public void setBtnText(String s){
        btnText = s;
    }
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {


        switch (btnText){
            case "Alpha":
                t.setAlpha(interpolatedTime);
                break;
            case "Translate":
                t.getMatrix().setTranslate((float) Math.sin(interpolatedTime*30)*40,0);//左右周期抖动
                break;
            case "Rotate":
                t.getMatrix().setRotate(720*interpolatedTime,0,0);
                break;
            case "Scale":
                t.getMatrix().setScale(1-interpolatedTime,1-interpolatedTime);
                break;
            default:
                t.getMatrix().setTranslate(0,(float) Math.sin(interpolatedTime*50)*20);
                break;
        }
        //t.setAlpha(interpolatedTime);
        //t.getMatrix().setTranslate(200*interpolatedTime,200*interpolatedTime);
        //t.getMatrix().setTranslate((float) Math.sin(interpolatedTime*50)*20,0);//左右周期抖动
        //t.getMatrix().setRotate(360*interpolatedTime,0,0);
        //t.getMatrix().setScale(2*interpolatedTime,2);
        //t.getMatrix().setTranslate(0,(float) Math.sin(interpolatedTime*50)*20);
        super.applyTransformation(interpolatedTime, t);

    }
}
