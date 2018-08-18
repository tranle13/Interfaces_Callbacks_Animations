
    // Name: Tran Le
    // AID - 1808
    // File name: DetailsFragment.java

package com.sunny.android.letran_ce06.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sunny.android.letran_ce06.Contact;
import com.sunny.android.letran_ce06.R;

public class DetailsFragment extends Fragment {

    private static final String KEY = "CONTACT_KEY";

    public DetailsFragment() {
        // Default empty constructor
    }

    public static DetailsFragment newInstance(Contact number) {

        Bundle args = new Bundle();

        args.putSerializable(KEY, number);

        DetailsFragment fragment = new DetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.details_fragment, container, false);
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            if (getArguments() != null) {
                if (getView() != null) {
                    Contact number = (Contact) getArguments().getSerializable(KEY);

                    ((TextView)getView().findViewById(R.id.txt_FirstName)).setText(number.getFirstName());
                    ((TextView)getView().findViewById(R.id.txt_LastName)).setText(number.getLastName());
                    ((TextView)getView().findViewById(R.id.txt_PhoneNumber)).setText(number.getPhoneNumber());
                }
            }
        }
    }
