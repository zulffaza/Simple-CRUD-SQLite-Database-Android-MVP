package com.example.sqlitedatabase.addcontact.view.fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sqlitedatabase.R;
import com.example.sqlitedatabase.addcontact.contract.AddContactContract;
import com.example.sqlitedatabase.addcontact.view.activity.AddContactActivity;
import com.example.sqlitedatabase.main.model.Contact;

/**
 * Merupakan class yang mengatur view add contact
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 10 Oktober 2017
 */
public class AddContactFragment extends Fragment implements AddContactContract.View {

    private AddContactContract.Presenter mPresenter;
    private ProgressDialog mProgressDialog;
    private TextInputEditText mTietName, mTietPhone, mTietEmail, mTietStreet, mTietPlace;
    private TextInputLayout mTilName;

    public AddContactFragment() {
        // Default constructor
    }

    public static AddContactFragment newInstance() {
        return new AddContactFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_contact, container, false);

        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        mProgressDialog = new ProgressDialog(getContext());
        String title = getString(R.string.add_contact_title);
        String message = getString(R.string.add_contact_message);

        mProgressDialog.setTitle(title);
        mProgressDialog.setMessage(message);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setCanceledOnTouchOutside(false);

        mTietName = view.findViewById(R.id.tiet_name);
        mTietPhone = view.findViewById(R.id.tiet_phone);
        mTietEmail = view.findViewById(R.id.tiet_email);
        mTietStreet = view.findViewById(R.id.tiet_street);
        mTietPlace = view.findViewById(R.id.tiet_place);

        mTilName = view.findViewById(R.id.til_name);

        getActivity().findViewById(R.id.fab_add_contact).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Contact contact = new Contact();

                contact.setname(mTietName.getText().toString());
                contact.setphone(mTietPhone.getText().toString());
                contact.setemail(mTietEmail.getText().toString());
                contact.setstreet(mTietStreet.getText().toString());
                contact.setplace(mTietPlace.getText().toString());

                mPresenter.saveContact(contact);
            }
        });

        return view;
    }

    @Override
    public void setPresenter(@NonNull AddContactContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showNameEmpty() {
        String nameEmpty = getString(R.string.name_empty);

        mTilName.setErrorEnabled(true);
        mTilName.setError(nameEmpty);
    }

    @Override
    public void hideNameEmpty() {
        mTilName.setErrorEnabled(false);
    }

    @Override
    public void showProgressDialog() {
        mProgressDialog.show();
    }

    @Override
    public void hideProgressDialog() {
        mProgressDialog.dismiss();
    }

    @Override
    public void finishView(@NonNull String message) {
        Intent intent = new Intent();
        intent.putExtra("message", message);

        getActivity().setResult(Activity.RESULT_OK, intent);
        getActivity().finish();
    }
}
