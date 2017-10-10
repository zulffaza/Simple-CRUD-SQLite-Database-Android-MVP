package com.example.sqlitedatabase.main.datasource;

import android.support.annotation.NonNull;

import com.example.sqlitedatabase.main.model.Contact;

import java.util.List;

/**
 * Merupakan interface yang mengatur apa saja yang dilakukan untuk mengakses database
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 10 Oktober 2017
 */
public interface MainDataSource {

    interface LoadContactsCallback {

        void onLoadSuccess();
        void onLoadFailed();
    }

    interface EditContactCallback {

        void onEditSuccess(@NonNull Contact contact);
        void onEditFailed();
    }

    interface DeleteContactCallback {

        void onDeleteSuccess(@NonNull Contact contact);
        void onDeleteFailed();
    }

    void loadContacts(@NonNull List users, @NonNull LoadContactsCallback loadContactsCallback);
    void editContact(@NonNull Contact contact, @NonNull EditContactCallback editContactCallback);
    void deleteContact(@NonNull Contact contact, @NonNull DeleteContactCallback deleteContactCallback);
}
