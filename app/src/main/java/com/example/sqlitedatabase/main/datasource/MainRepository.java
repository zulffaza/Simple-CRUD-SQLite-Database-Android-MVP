package com.example.sqlitedatabase.main.datasource;

import android.support.annotation.NonNull;

import com.example.sqlitedatabase.main.datasource.local.MainLocalDataSource;
import com.example.sqlitedatabase.main.model.Contact;

import java.util.List;

/**
 * Merupakan class yang akan melakukan akses ke database
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 10 Oktober 2017
 */
public class MainRepository implements MainDataSource {

    private static MainRepository sInstance = null;
    private MainLocalDataSource mMainLocalDataSource;

    private MainRepository(@NonNull MainLocalDataSource mainLocalDataSource) {
        mMainLocalDataSource = mainLocalDataSource;
    }

    public static MainRepository getInstance(@NonNull MainLocalDataSource mainLocalDataSource) {
        if (sInstance == null)
            sInstance = new MainRepository(mainLocalDataSource);

        return sInstance;
    }

    public static void destroyInstance() {
        sInstance = null;
    }

    @Override
    public void loadContacts(@NonNull List users, @NonNull LoadContactsCallback loadContactsCallback) {
        mMainLocalDataSource.loadContacts(users, loadContactsCallback);
    }

    @Override
    public void editContact(@NonNull Contact contact, @NonNull EditContactCallback editContactCallback) {
        // TODO edit contacts
    }

    @Override
    public void deleteContact(@NonNull Contact contact, @NonNull DeleteContactCallback deleteContactCallback) {
        mMainLocalDataSource.deleteContact(contact, deleteContactCallback);
    }
}
