package com.zhangxt4.tabviewpagerindicator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by zhangxt4 on 2016/2/4.
 */
public class QaFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.indicatorfrgment, container, false);
        TextView fragmentTv = (TextView) view.findViewById(R.id.id_fragmenttv);
        fragmentTv.setText("问答的Fragment");
        return view;
    }
}
