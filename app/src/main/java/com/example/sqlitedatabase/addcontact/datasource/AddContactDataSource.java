package com.example.sqlitedatabase.addcontact.datasource;

import android.support.annotation.NonNull;

import com.example.sqlitedatabase.main.model.Contact;

/**
 * Merupakan interface yang mengatur apa saja yang dilakukan saat mengakses database
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 10 Oktober 2017
 */
public interface AddContactDataSource {

    interface InsertContactCallback {

        void onInsertSuccess();
        void onInsertFailed();
    }

    void insertContact(@NonNull Contact contact, @NonNull InsertContactCallback insertContactCallback);
}
