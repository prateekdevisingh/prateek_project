package com.prateek.demovideotap.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import com.prateek.demovideotap.R;
import com.prateek.demovideotap.adapter.HomeContentAdapter;
import com.prateek.demovideotap.adapter.ItemDescriptionAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by prateek on 19/7/17.
 */

public class ItemPageActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView rvForUpContent;
    private ExpandableListView elvDescription;
    private ItemDescriptionAdapter itemDescriptionAdapter;
    private List<String> listHeaderData;
    private HashMap<String, List<String>> listChildData;
    private LinearLayout linearLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_page_activity);
        getSupportActionBar().hide();
        initializeView();

    }

    private void initializeView() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        findViewById(R.id.ivBack).setOnClickListener(this);

        for (int index = 0 ; index < 1 ; index++){
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.rlContent);
            LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
            View viewCenterContent = layoutInflater.inflate(R.layout.home_content_layout, null);
            Button button = new Button(this);
            LinearLayout.LayoutParams lpForCenterContent = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300);
            lpForCenterContent.setMargins(40, 40, 40, 40);
            button.setText(String.valueOf(index));
            button.setTextSize(16);

            rvForUpContent = (RecyclerView) viewCenterContent.findViewById(R.id.recyclerViewContent);
            rvForUpContent.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
            HomeContentAdapter homeContentAdapter = new HomeContentAdapter(this, index);
            rvForUpContent.setAdapter(homeContentAdapter);
            button.setLayoutParams(lpForCenterContent);
            linearLayout.addView(viewCenterContent);

        }
//        elvDescription = (ExpandableListView) findViewById(R.id.elvDescription);


//        prepareListData();


//        itemDescriptionAdapter = new ItemDescriptionAdapter(this, listHeaderData, listChildData);


//        elvDescription.setAdapter(itemDescriptionAdapter);
    }

    private void prepareListData() {
        listHeaderData = new ArrayList<String>();
        listChildData = new HashMap<String, List<String>>();

        listHeaderData.add(getResources().getString(R.string.key_feature));
        listHeaderData.add(getResources().getString(R.string.content));
        listHeaderData.add(getResources().getString(R.string.quantity));
        listHeaderData.add(getResources().getString(R.string.disclaimer));

        List<String> childKeyFeature = new ArrayList<>();
        childKeyFeature.add(getResources().getString(R.string.key_feature_data));

        List<String> childContents = new ArrayList<>();
        childContents.add(getResources().getString(R.string.content_data));

        List<String> childQuantity = new ArrayList<>();
        childQuantity.add(getResources().getString(R.string.quantity_data));

        List<String> childDisclaimer = new ArrayList<>();
        childDisclaimer.add(getResources().getString(R.string.disclaimer_data));

        listChildData.put(listHeaderData.get(0), childKeyFeature);
        listChildData.put(listHeaderData.get(1), childContents);
        listChildData.put(listHeaderData.get(2), childQuantity);
        listChildData.put(listHeaderData.get(3), childDisclaimer);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ivBack:
                finishActivity();
                break;
        }
    }

    private void finishActivity() {
        this.finish();
        overridePendingTransition(R.anim.anim_in_right_from_left, R.anim.anim_out_right);
    }
}
