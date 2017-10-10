package com.example.sqlitedatabase.addcontact.datasource;

import android.support.annotation.NonNull;

import com.example.sqlitedatabase.addcontact.datasource.local.AddContactLocalDataSource;
import com.example.sqlitedatabase.main.model.Contact;

/**
 * Merupakan class yang akan melakukan akses ke database
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 10 Oktober 2017
 */
public class AddContactRepository implements AddContactDataSource {

    private static AddContactRepository sInstance = null;
    private AddContactLocalDataSource mAddContactLocalDataSource;

    private AddContactRepository(@NonNull AddContactLocalDataSource addContactLocalDataSource) {
        mAddContactLocalDataSource = addContactLocalDataSource;
    }

    public static AddContactRepository getInstance(@NonNull AddContactLocalDataSource addContactLocalDataSource) {
        if (sInstance == null)
            sInstance = new AddContactRepository(addContactLocalDataSource);

        return sInstance;
    }

    public static void destroyInstance() {
        sInstance = null;
    }

    @Override
    public void insertContact(@NonNull Contact contact, @NonNull InsertContactCallback insertContactCallback) {
        mAddContactLocalDataSource.insertContact(contact, insertContactCallback);
    }
}
