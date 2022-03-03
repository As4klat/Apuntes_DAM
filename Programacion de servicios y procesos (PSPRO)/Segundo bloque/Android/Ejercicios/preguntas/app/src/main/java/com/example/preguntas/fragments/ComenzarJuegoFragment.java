package com.example.preguntas.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.preguntas.R;

public class ComenzarJuegoFragment extends Fragment {
    private static final String TEXT = "text";

    public static ComenzarJuegoFragment newInstance(String text) {
        ComenzarJuegoFragment frag = new ComenzarJuegoFragment();

        Bundle args = new Bundle();
        args.putString(TEXT, text);
        frag.setArguments(args);

        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.comenzarjuego_fragment, container, false);
        if (getArguments() != null) {
            ((TextView) layout.findViewById(R.id.text)).setText(getArguments().getString(TEXT));
        }
        return layout;
    }
}
