package com.example.sqlitedatabase.addcontact.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sqlitedatabase.R;
import com.example.sqlitedatabase.addcontact.presenter.AddContactPresenter;
import com.example.sqlitedatabase.addcontact.view.fragment.AddContactFragment;
import com.example.sqlitedatabase.utils.ActivityUtils;
import com.example.sqlitedatabase.utils.Injection;

public class AddContactActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 9165;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        AddContactFragment addContactFragment = AddContactFragment.newInstance();
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), addContactFragment,
                R.id.fl_add_contact);

        new AddContactPresenter(Injection.proviceAddContactRepository(this), addContactFragment);
    }
}
