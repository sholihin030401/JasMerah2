package com.project.ichwan.gemastik.kerja;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.ichwan.gemastik.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class KandidatFragment extends Fragment {

    public KandidatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kandidat, container, false);
    }
}
