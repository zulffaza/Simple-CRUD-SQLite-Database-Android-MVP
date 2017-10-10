package com.example.sqlitedatabase.main.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;

import com.example.sqlitedatabase.addcontact.view.activity.AddContactActivity;
import com.example.sqlitedatabase.main.contract.MainContract;
import com.example.sqlitedatabase.main.datasource.MainDataSource;
import com.example.sqlitedatabase.main.datasource.MainRepository;
import com.example.sqlitedatabase.main.model.Contact;

import java.util.List;

/**
 * Merupakan presenter yang mengatur logic dari main
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 10 Oktober 2017
 */
public class MainPresenter implements MainContract.Presenter {

    private final MainContract.View mView;
    private final MainRepository mMainRepository;

    public MainPresenter(MainRepository mainRepository, MainContract.View view) {
        mMainRepository = mainRepository;
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void onCreate() {
        // Do nothing
    }

    @Override
    public void onStart() {
        // Do nothing
    }

    @Override
    public void onResume() {
        mView.showContacts();
    }

    @Override
    public void onPause() {
        // Do nothing
    }

    @Override
    public void onStop() {
        // Do nothing
    }

    @Override
    public void onDestroy() {
        // Do nothing
    }

    @Override
    public void loadContacs(@NonNull List users) {
        mMainRepository.loadContacts(users, new MainDataSource.LoadContactsCallback() {

            @Override
            public void onLoadSuccess() {
                Log.d("On Load Success", "Contacts load success");
            }

            @Override
            public void onLoadFailed() {
                Log.d("On Load Failed", "Contacts load failed");
            }
        });
    }

    @Override
    public void openContactMenu(@NonNull Contact contact, @NonNull View view) {
        mView.showContactMenu(contact, view);
    }

    @Override
    public void editContact(@NonNull Contact contact) {
        // TODO edit contact
    }

    @Override
    public void deleteContact(@NonNull Contact contact) {
        mMainRepository.deleteContact(contact, new MainDataSource.DeleteContactCallback() {

            @Override
            public void onDeleteSuccess(@NonNull Contact contact) {
                mView.updateDeletedContacts(contact);
            }

            @Override
            public void onDeleteFailed() {
                // TODO show alert failed
            }
        });
    }

    @Override
    public void openAddContact() {
        mView.showAddContact();
    }

    @Override
    public void resultAddContact(@NonNull Integer requestCode, @NonNull Integer resultCode,
                                 @NonNull Intent data) {
        if (requestCode == AddContactActivity.REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            Bundle bundle = data.getExtras();
            String message = bundle.getString("message");

            if (message != null)
                mView.showAddUserMessage(message);
        }
    }
}
