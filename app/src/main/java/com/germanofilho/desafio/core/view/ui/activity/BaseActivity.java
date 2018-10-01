package com.germanofilho.desafio.core.view.ui.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.germanofilho.desafio.R;
import com.germanofilho.desafio.core.view.BaseView;

import butterknife.ButterKnife;

/**
 * Created by germano on 22/06/18.
 * germanof16@gmail.com
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initButterKnife();
    }

    public abstract @LayoutRes
    int getLayout();


    @Override
    public void isToShowProgressBar(boolean value) {
        if(value) findViewById(R.id.progress_bar).setVisibility(View.VISIBLE);
        else findViewById(R.id.progress_bar).setVisibility(View.GONE);
    }


    private void initButterKnife(){
        ButterKnife.bind(this);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }
}
