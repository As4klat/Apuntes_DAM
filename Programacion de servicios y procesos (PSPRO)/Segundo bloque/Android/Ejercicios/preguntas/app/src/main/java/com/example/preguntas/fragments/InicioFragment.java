package com.example.preguntas.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.preguntas.R;

public class InicioFragment extends Fragment {
    private static final String TEXT = "text";

    public static InicioFragment newInstance(String text) {
        InicioFragment frag = new InicioFragment();

        Bundle args = new Bundle();
        args.putString(TEXT, text);
        frag.setArguments(args);

        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.inicio_fragment, container, false);
        return layout;
    }
}
