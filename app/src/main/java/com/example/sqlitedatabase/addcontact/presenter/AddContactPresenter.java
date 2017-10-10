package com.example.sqlitedatabase.addcontact.presenter;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.example.sqlitedatabase.addcontact.contract.AddContactContract;
import com.example.sqlitedatabase.addcontact.datasource.AddContactDataSource;
import com.example.sqlitedatabase.addcontact.datasource.AddContactRepository;
import com.example.sqlitedatabase.main.model.Contact;

/**
 * Merupakan presenter yang mengatur logic dari add contact
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 10 Oktober 2017
 */
public class AddContactPresenter implements AddContactContract.Presenter {

    private final AddContactContract.View mView;
    private final AddContactRepository mAddContactRepository;

    public AddContactPresenter(AddContactRepository addContactRepository, AddContactContract.View view) {
        mAddContactRepository = addContactRepository;
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
        // Do nothing
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
    public void saveContact(@NonNull Contact contact) {
        mView.showProgressDialog();

        if (TextUtils.isEmpty(contact.getname()))
            mView.showNameEmpty();
        else {
            mView.hideNameEmpty();
            mAddContactRepository.insertContact(contact, new AddContactDataSource.InsertContactCallback() {

                @Override
                public void onInsertSuccess() {
                    mView.hideProgressDialog();
                    mView.finishView("Insert contact success");
                }

                @Override
                public void onInsertFailed() {
                    mView.hideProgressDialog();
                    mView.finishView("Insert contact failed");
                }
            });
        }
    }
}
