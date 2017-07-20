package com.prateek.demovideotap.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import com.prateek.demovideotap.R;


/**
 * Created by prateek on 18/7/17.
 */

public class MultipleRoleActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnDemo;
    private LinearLayout llDemo;
    private boolean CHECK = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiple_role_activity);
        llDemo = (LinearLayout) findViewById(R.id.llDemo);
        btnDemo = (Button) findViewById(R.id.btnDemo);
        btnDemo.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnDemo:
                if(CHECK == true){
                    animateFunction(1);
                    CHECK = false;
                } else if (CHECK == false){
                    animateFunction(2);
                    CHECK = true;
                }
                break;
        }
    }

    private void animateFunction(int numCheck) {
        if(numCheck == 1){
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in_left_from_right);
            llDemo.setVisibility(View.VISIBLE);
            llDemo.setAnimation(animation);
        } else if (numCheck == 2){
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_in_right_from_left);
            llDemo.setVisibility(View.GONE);
            llDemo.setAnimation(animation);
        }
    }


}
