package com.germanofilho.desafio.core.view.ui.fragment;

import android.support.v4.app.Fragment;
import android.view.View;

import com.germanofilho.desafio.R;
import com.germanofilho.desafio.core.view.BaseView;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by germano on 23/06/18.
 * germanof16@gmail.com
 */

public abstract class BaseFragment extends Fragment implements BaseView{

    @Override
    public void isToShowProgressBar(boolean value) {
        if(value) getActivity().findViewById(R.id.progress_bar).setVisibility(View.VISIBLE);
        else getActivity().findViewById(R.id.progress_bar).setVisibility(View.GONE);
    }

    public void initButterKnife(){
        if(getView() != null){
            ButterKnife.bind(this, getView());
        }
    }
}
