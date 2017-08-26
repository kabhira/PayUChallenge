package com.abhi.payuchallengeabhiraj.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abhi.payuchallengeabhiraj.R;
import com.abhi.payuchallengeabhiraj.events.EventBusSingleton;
import com.abhi.payuchallengeabhiraj.model.DataManager;
import com.abhi.payuchallengeabhiraj.model.KickStartResponseElement;
import com.abhi.payuchallengeabhiraj.utilities.ListAdapter;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 *  Author: Abhiraj Khare
 *  Description: Fragment to show project list
 */

public class KickListFragment extends Fragment {

    private List<KickStartResponseElement> mDataset;
    private ListAdapter mAdapter;


    public KickListFragment() {
        // Required empty public constructor
    }

    public static KickListFragment newInstance() {
        KickListFragment fragment = new KickListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_kick_list, container, false);

        mDataset = new ArrayList<>();
        RecyclerView mRecyclerView = (RecyclerView) rootView.findViewById(R.id.item_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ListAdapter(mDataset, getActivity());
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateArray(null);
        EventBusSingleton.instance().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        EventBusSingleton.instance().unregister(this);
    }

    @Subscribe
    public void updateArray(KickStartResponseElement[] data){
        mDataset.clear();
        mDataset.addAll(DataManager.instance().getMainList());
        mAdapter.notifyDataSetChanged();

    }

}
