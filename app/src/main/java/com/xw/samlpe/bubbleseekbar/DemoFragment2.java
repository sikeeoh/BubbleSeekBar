package com.xw.samlpe.bubbleseekbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xw.repo.BubbleSeekBar;

import java.util.HashMap;

/**
 * DemoFragment2
 * <><p/>
 * Created by woxingxiao on 2017-03-11.
 */

public class DemoFragment2 extends Fragment {
    private HashMap<Integer, String> sectionTextMap;
    private BubbleSeekBar bubbleSeekBar;

    public static DemoFragment2 newInstance() {
        return new DemoFragment2();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_demo_2, container, false);
        initViews(view);
        initData();

        bubbleSeekBar.getConfigBuilder().sectionTextMap(sectionTextMap).build();
        return view;
    }

    private void initViews(View view) {
        bubbleSeekBar = (BubbleSeekBar)view.findViewById(R.id.bsb_custom_section_data);
    }

    private void initData() {
        sectionTextMap = new HashMap<>();
        sectionTextMap.put(2, "hi");
        sectionTextMap.put(5, "bye");
    }
}
