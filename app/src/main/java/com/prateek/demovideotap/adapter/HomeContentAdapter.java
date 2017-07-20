package com.prateek.demovideotap.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.prateek.demovideotap.R;

import java.util.ArrayList;

/**
 * Created by prateek on 18/7/17.
 */

public class HomeContentAdapter extends RecyclerView.Adapter {
    int number;
    Context context;

    public HomeContentAdapter(Activity activity, int number) {
        this.number = number;
        this.context = activity;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_content, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        try {
            ViewHolder viewHolder = (ViewHolder) holder;
            viewHolder.tvGenreName.setText(String.valueOf(position));

        }catch (Exception e){
           e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return 7;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvGenreName;

        public ViewHolder(View itemView) {
            super(itemView);
            tvGenreName = (TextView) itemView.findViewById(R.id.tvGenreName);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            /*layoutGenreIcon.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams param = new RelativeLayout.LayoutParams(newWidth / 2, newWidth / 2);
            param.addRule(RelativeLayout.CENTER_IN_PARENT);
            ivGenreIcon.setLayoutParams(param);
            layoutGenreIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(activity, GenreDetailsActivity.class);
                    HomeGenreCategory genreCategory = genreCategoryArrayList.get((int) v.getTag());
                    intent.putExtra("GENRE_ID", genreCategory.getKey());
                    intent.putExtra("GENRE_VALUE", genreCategory.getValue());

                    activity.startActivity(intent);
                    activity.overridePendingTransition(R.anim.anim_in_left_from_right, R.anim.anim_out_left);

                }
            });*/
        }
    }
}
