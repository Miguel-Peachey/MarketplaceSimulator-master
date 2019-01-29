package com.miguelpeachey.marketplacesimulator.Fragments;


import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.miguelpeachey.marketplacesimulator.R;

import java.util.Objects;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {

    ImageView ivImage1, ivImage2, ivImage3, ivImage4, ivImage5, ivImage6;
    SharedPreferences myPreferences;

    public SettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_settings, container, false);

        final TextInputEditText teiUserName = view.findViewById(R.id.teiUserName);
        TextView tvChangeProfilePicture = view.findViewById(R.id.tvChangeProfilePicture);
        final ImageView ivSettingsProfilePicture = view.findViewById(R.id.ivSettingsProfilePicture);
        final Button btnApplyChanges = view.findViewById(R.id.btnApplyChanges);

        SharedPreferences.Editor editor = getActivity().getSharedPreferences("myPrefs", MODE_PRIVATE).edit();
        editor.putString("profilePicture", "default");
        editor.apply();


        btnApplyChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String user_name = String.valueOf(teiUserName.getText());

                SharedPreferences.Editor editor = getActivity().getSharedPreferences("myPrefs", MODE_PRIVATE).edit();
                editor.putString("name", user_name);
                editor.apply();

                btnApplyChanges.setVisibility(View.INVISIBLE);

                Toast.makeText(getContext(), "Username saved as " + user_name, Toast.LENGTH_SHORT).show();

            }
        });

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("myPrefs", Context.MODE_PRIVATE);

        final String usernameID = sharedPreferences.getString("name", "User");

        teiUserName.setText(usernameID);

        tvChangeProfilePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = getActivity().getLayoutInflater();
                final View dialogView = inflater.inflate(R.layout.custom_dialog_profile, null);
                builder.setView(dialogView);

                ivImage1 = dialogView.findViewById(R.id.tvImage1);
                ivImage2 = dialogView.findViewById(R.id.tvImage2);
                ivImage3 = dialogView.findViewById(R.id.tvImage3);
                ivImage4 = dialogView.findViewById(R.id.tvImage4);
                ivImage5 = dialogView.findViewById(R.id.tvImage5);
                ivImage6 = dialogView.findViewById(R.id.tvImage6);

                Button btnCloseDialog = dialogView.findViewById(R.id.btnCloseDialog);

                final AlertDialog dialog = builder.show();

                btnCloseDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dialog.dismiss();

                    }
                });

                ivImage1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ivSettingsProfilePicture.setImageResource(R.drawable.casual_man);

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("imagePrefs", MODE_PRIVATE).edit();
                        editor.putString("image", "1");
                        editor.apply();

                        dialog.dismiss();
                    }
                });

                ivImage2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ivSettingsProfilePicture.setImageResource(R.drawable.formal_man);

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("imagePrefs", MODE_PRIVATE).edit();
                        editor.putString("image", "2");
                        editor.apply();

                        dialog.dismiss();
                    }
                });

                ivImage3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ivSettingsProfilePicture.setImageResource(R.drawable.glasses_man);

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("imagePrefs", MODE_PRIVATE).edit();
                        editor.putString("image", "3");
                        editor.apply();

                        dialog.dismiss();
                    }
                });

                ivImage4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ivSettingsProfilePicture.setImageResource(R.drawable.brunette_woman);

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("imagePrefs", MODE_PRIVATE).edit();
                        editor.putString("image", "4");
                        editor.apply();

                        dialog.dismiss();
                    }
                });

                ivImage5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ivSettingsProfilePicture.setImageResource(R.drawable.blonde_woman);

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("imagePrefs", MODE_PRIVATE).edit();
                        editor.putString("image", "5");
                        editor.apply();

                        dialog.dismiss();
                    }
                });

                ivImage6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ivSettingsProfilePicture.setImageResource(R.drawable.short_woman);

                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("imagePrefs", MODE_PRIVATE).edit();
                        editor.putString("image", "6");
                        editor.apply();

                        dialog.dismiss();
                    }
                });
            }
        });

        myPreferences = getActivity().getSharedPreferences("imagePrefs", Context.MODE_PRIVATE);
        final String imageID = myPreferences.getString("image", "7");

        if (imageID.equals(String.valueOf("1"))) {
            ivSettingsProfilePicture.setImageResource(R.drawable.casual_man);
        } else if (imageID.equals(String.valueOf("2"))) {
            ivSettingsProfilePicture.setImageResource(R.drawable.formal_man);
        } else if (imageID.equals(String.valueOf("3"))) {
            ivSettingsProfilePicture.setImageResource(R.drawable.glasses_man);
        } else if (imageID.equals(String.valueOf("4"))) {
            ivSettingsProfilePicture.setImageResource(R.drawable.brunette_woman);
        } else if (imageID.equals(String.valueOf("5"))) {
            ivSettingsProfilePicture.setImageResource(R.drawable.blonde_woman);
        } else if (imageID.equals(String.valueOf("6"))) {
            ivSettingsProfilePicture.setImageResource(R.drawable.short_woman);
        } else if (imageID.equals(String.valueOf("7"))) {
            ivSettingsProfilePicture.setImageResource(R.drawable.blank_avatar);
        }

        teiUserName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.toString().trim().length() == 0) {
                    btnApplyChanges.setVisibility(View.INVISIBLE);
                } else {
                    btnApplyChanges.setVisibility(View.VISIBLE);
                }

                if (teiUserName.getText().toString().equals(usernameID)) {
                    btnApplyChanges.setVisibility(View.INVISIBLE);
                } else {
                    btnApplyChanges.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return view;

    }
}

