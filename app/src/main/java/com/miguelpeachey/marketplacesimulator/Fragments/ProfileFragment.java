package com.miguelpeachey.marketplacesimulator.Fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.miguelpeachey.marketplacesimulator.Fragments.SubBuyFragments.BankAccountFragment;
import com.miguelpeachey.marketplacesimulator.Fragments.SubBuyFragments.ItemsFragment;
import com.miguelpeachey.marketplacesimulator.R;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    SharedPreferences sharedPreferences, imageSharedPreferences;

    RelativeLayout relativeLayout;

    AnimationDrawable animationDrawable;


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_profile, container, false);

        ImageView ivUserImageProfile = view.findViewById(R.id.ivUserImageProfile);
        TextView tvUsernameProfile = view.findViewById(R.id.tvUsernameProfile);
        relativeLayout = view.findViewById(R.id.relativeLayout);
        animationDrawable = (AnimationDrawable) relativeLayout.getBackground();

        animationDrawable.setEnterFadeDuration(1);
        animationDrawable.setExitFadeDuration(500);

        sharedPreferences = getActivity().getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
        final String usernameID = sharedPreferences.getString("name", "User");
        tvUsernameProfile.setText(usernameID);

        imageSharedPreferences = getActivity().getSharedPreferences("imagePrefs", Context.MODE_PRIVATE);
        final String imageID = imageSharedPreferences.getString("image", "7");

        if (imageID.equals(String.valueOf("1"))) {
            ivUserImageProfile.setImageResource(R.drawable.casual_man);
        } else if (imageID.equals(String.valueOf("2"))) {
            ivUserImageProfile.setImageResource(R.drawable.formal_man);
        } else if (imageID.equals(String.valueOf("3"))) {
            ivUserImageProfile.setImageResource(R.drawable.glasses_man);
        } else if (imageID.equals(String.valueOf("4"))) {
            ivUserImageProfile.setImageResource(R.drawable.brunette_woman);
        } else if (imageID.equals(String.valueOf("5"))) {
            ivUserImageProfile.setImageResource(R.drawable.blonde_woman);
        } else if (imageID.equals(String.valueOf("6"))) {
            ivUserImageProfile.setImageResource(R.drawable.short_woman);
        } else if (imageID.equals(String.valueOf("7"))) {
            ivUserImageProfile.setImageResource(R.drawable.blank_avatar);
        }

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (animationDrawable != null && !animationDrawable.isRunning()) {
            // start the animation
            animationDrawable.start();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (animationDrawable != null && animationDrawable.isRunning()) {
            // stop the animation
            animationDrawable.stop();
        }
    }
}
