package com.example.sqlitedatabase.main.datasource.local;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.example.sqlitedatabase.main.datasource.MainDataSource;
import com.example.sqlitedatabase.main.model.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Merupakan class yang menghandle pengambilan data dari local
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 10 Oktober 2017
 */
public class MainLocalDataSource implements MainDataSource {

    private static MainLocalDataSource sInstance = null;
    private final Context mContext;
    private final ContactHelper mContactHelper;

    private MainLocalDataSource(@NonNull Context context) {
        mContext = context;
        mContactHelper = new ContactHelper(mContext);
    }

    public static MainLocalDataSource getInstance(@NonNull Context context) {
        if (sInstance == null)
            sInstance = new MainLocalDataSource(context);

        return sInstance;
    }

    public static void destroyInstance() {
        sInstance = null;
    }

    @Override
    public void loadContacts(@NonNull List users, @NonNull LoadContactsCallback loadContactsCallback) {
        ArrayList<Contact> usersArrayList = (ArrayList<Contact>) users;
        SQLiteDatabase sqLiteDatabase = mContactHelper.getReadableDatabase();
        String sql = "select * from " + ContactHelper.CONTACTS_TABLE_NAME;

        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        cursor.moveToFirst();

        if (cursor.getCount() > 0) {
            do {
                Contact contact = mContactHelper.relationalToObject(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5)
                );

                usersArrayList.add(contact);
            } while (cursor.moveToNext());
        }

        cursor.close();
        sqLiteDatabase.close();
        loadContactsCallback.onLoadSuccess();
    }

    @Override
    public void editContact(@NonNull Contact contact, @NonNull EditContactCallback editContactCallback) {
        // TODO edit contacts
    }

    @Override
    public void deleteContact(@NonNull Contact contact, @NonNull DeleteContactCallback deleteContactCallback) {
        SQLiteDatabase sqLiteDatabase = mContactHelper.getWritableDatabase();
        int returnValue = sqLiteDatabase.delete(ContactHelper.CONTACTS_TABLE_NAME, "id = ?",
                new String[]{Integer.toString(contact.getid())});

        if (returnValue != 0)
            deleteContactCallback.onDeleteSuccess(contact);
        else
            deleteContactCallback.onDeleteFailed();
    }
}
