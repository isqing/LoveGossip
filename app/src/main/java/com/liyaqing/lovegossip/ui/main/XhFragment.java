package com.liyaqing.lovegossip.ui.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liyaqing.lovegossip.R;

public class XhFragment extends Fragment {

    public XhFragment() {
        // Required empty public constructor
    }

    public static XhFragment newInstance() {
        XhFragment fragment = new XhFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_xh, container, false);
    }

}
