package com.prateek.demovideotap.utility;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.view.View;

import com.prateek.demovideotap.R;
import com.prateek.demovideotap.activity.SearchActivity;

/**
 * Created by prateek on 18/7/17.
 */

public class Utility {

    public static void openSearch(View view, Activity activity) {
        if (Constant.DEVICE == Constant.DEVICE_TABLET) {
//            openSearchTablet(activity);
        } else {
            Intent intent = new Intent(activity, SearchActivity.class);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
          /*  ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(activity, view, view.getTransitionName());
            activity.startActivity(intent, options.toBundle());*/
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.anim_in_left_from_right, R.anim.anim_out_left);
            } else {
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.anim_in_left_from_right, R.anim.anim_out_left);
            }
        }
    }
}
