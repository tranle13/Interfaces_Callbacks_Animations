
    // Name: Tran Le
    // AID - 1808
    // File name: ContactListFragment.java

package com.sunny.android.letran_ce06.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sunny.android.letran_ce06.Contact;
import com.sunny.android.letran_ce06.R;

import java.util.ArrayList;

public class ContactListFragment extends ListFragment {

    private static final String CONTACT_KEY = "SAVE_CONTACT";
    GetContact cListener;

    public interface GetContact {
        public void getContact(int index);
    }

    public ContactListFragment() {
        // Default empty constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof GetContact) {
            cListener = (GetContact)context;
        }
    }

    public static ContactListFragment newInstance(ArrayList<Contact> contacts) {

        Bundle args = new Bundle();

        args.putSerializable(CONTACT_KEY, contacts);

        ContactListFragment fragment = new ContactListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.listview_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getArguments() != null) {
            ArrayList<Contact> contacts = (ArrayList<Contact>)getArguments().getSerializable(CONTACT_KEY);
            ArrayAdapter<Contact> adapter = new ArrayAdapter<>(
                    getContext(), android.R.layout.simple_list_item_1, contacts
            );

            setListAdapter(adapter);
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        cListener.getContact(position);
    }
}
