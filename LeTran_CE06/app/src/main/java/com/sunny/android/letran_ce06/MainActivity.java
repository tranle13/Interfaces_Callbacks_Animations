
    // Name: Tran Le
    // AID - 1808
    // File name: MainActivity.java

package com.sunny.android.letran_ce06;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.sunny.android.letran_ce06.fragments.AddContactFragment;
import com.sunny.android.letran_ce06.fragments.ContactListFragment;
import com.sunny.android.letran_ce06.fragments.DetailsFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ContactListFragment.GetContact, AddContactFragment.PassContact {

    private ArrayList<Contact> contacts = new ArrayList<>();
    private Animation scaleUp;
    private Animation scaleDown;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);
        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().addToBackStack(null).
                        setCustomAnimations(R.animator.slide_in_left, 0, 0, R.animator.slide_out_right).
                        add(R.id.fragmentHolder, AddContactFragment.newInstance()).commit();

                fab.startAnimation(scaleDown);
                fab.hide();
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

        fab.startAnimation(scaleDown);
        fab.hide();
    }

    @Override
    public void passContact(Contact newContact) {
        contacts.add(newContact);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentHolder,
                ContactListFragment.newInstance(contacts)).commit();

        fab.startAnimation(scaleUp);
        fab.show();
    }
}
