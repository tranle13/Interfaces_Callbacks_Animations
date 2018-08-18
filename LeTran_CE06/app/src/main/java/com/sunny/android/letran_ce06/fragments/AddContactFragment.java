
    // Name: Tran Le
    // AID - 1808
    // File name: AddContactFragment.java

package com.sunny.android.letran_ce06.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.sunny.android.letran_ce06.Contact;
import com.sunny.android.letran_ce06.R;

public class AddContactFragment extends Fragment implements View.OnClickListener {

    PassContact newContact;
    private static final String TAG = "AddContactFragment";

    public interface PassContact {
        public void passContact(Contact newContact);
    }

    public AddContactFragment() {
        // Default empty constructor
    }

    public static AddContactFragment newInstance() {

        Bundle args = new Bundle();

        AddContactFragment fragment = new AddContactFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof PassContact) {
            newContact = (PassContact)context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.addcontact_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getView() != null) {
            ((Button)getView().findViewById(R.id.btn_AddContact)).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        if (getView() != null) {
            EditText firstName = (EditText)getView().findViewById(R.id.etx_FirstName);
            EditText lastName = (EditText)getView().findViewById(R.id.etx_LastName);
            EditText phoneNum = (EditText)getView().findViewById(R.id.etx_PhoneNumber);
            String strFirstName = firstName.getText().toString();
            String strLastName = lastName.getText().toString();
            String strPhone = phoneNum.getText().toString();
            Integer phoneNumber = Integer.parseInt(strPhone);

            if (phoneNumber != null) {
                getFragmentManager().popBackStack();
                Contact newPerson = new Contact(strFirstName, strLastName, phoneNumber);
                newContact.passContact(newPerson);
                try {
                    getActivity().getSupportFragmentManager().popBackStack();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                ((EditText)view.findViewById(R.id.etx_PhoneNumber)).setError(getString(R.string.app_name));
            }
        }
    }
}
