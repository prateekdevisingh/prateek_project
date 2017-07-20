package com.prateek.demovideotap.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.view.Window;

import com.prateek.demovideotap.R;
import com.prateek.demovideotap.utility.Utility;

/**
 * Created by prateek on 18/7/17.
 */

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);
        getSupportActionBar().hide();

        initializeView();
    }

    private void initializeView() {

        AppCompatImageView ivSearch = (AppCompatImageView)findViewById(R.id.ivSearch);
//        ivSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ivBack:
                Utility.openSearch(findViewById(R.id.toolbar), this);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        finishActivity();

    }

    private void finishActivity() {
        this.finish();
        overridePendingTransition(R.anim.anim_in_right_from_left, R.anim.anim_out_right);
    }
}
