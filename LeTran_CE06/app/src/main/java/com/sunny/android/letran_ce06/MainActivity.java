
    // Name: Tran Le
    // AID - 1808
    // File name: MainActivity.java

package com.sunny.android.letran_ce06;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.sunny.android.letran_ce06.fragments.AddContactFragment;
import com.sunny.android.letran_ce06.fragments.ContactListFragment;
import com.sunny.android.letran_ce06.fragments.DetailsFragment;

import java.util.ArrayList;

    public class MainActivity extends AppCompatActivity implements ContactListFragment.GetContact {

    ArrayList<Contact> contacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

                getSupportFragmentManager().beginTransaction().
                        setCustomAnimations(R.animator.slide_in_left, 0, 0, R.animator.slide_out_right).
                        add(R.id.fragmentHolder, AddContactFragment.newInstance()).commit();
            }

        });

        getSupportFragmentManager().beginTransaction().add(R.id.fragmentHolder,
                ContactListFragment.newInstance(contacts)).commit();
    }

    @Override
    public void getContact(int index) {
        Contact chosenContact = contacts.get(index);

        getSupportFragmentManager().beginTransaction().addToBackStack(null).
                setCustomAnimations(R.animator.slide_in_left, 0, 0, R.animator.slide_out_right).
                add(R.id.fragmentHolder, DetailsFragment.newInstance(chosenContact)).commit();
    }
}
