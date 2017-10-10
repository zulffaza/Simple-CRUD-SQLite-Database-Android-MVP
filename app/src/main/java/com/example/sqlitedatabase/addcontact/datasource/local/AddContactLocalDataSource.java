package com.example.sqlitedatabase.addcontact.datasource.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.example.sqlitedatabase.addcontact.datasource.AddContactDataSource;
import com.example.sqlitedatabase.main.datasource.local.ContactHelper;
import com.example.sqlitedatabase.main.model.Contact;

/**
 * Merupakan class yang menghandle pengambilan data dari local
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 10 Oktober 2017
 */
public class AddContactLocalDataSource implements AddContactDataSource {

    private static AddContactLocalDataSource sInstance = null;
    private final Context mContext;
    private final ContactHelper mContactHelper;

    private AddContactLocalDataSource(@NonNull Context context) {
        mContext = context;
        mContactHelper = new ContactHelper(mContext);
    }

    public static AddContactLocalDataSource getInstance(@NonNull Context context) {
        if (sInstance == null)
            sInstance = new AddContactLocalDataSource(context);

        return sInstance;
    }

    public static void destroyInstance() {
        sInstance = null;
    }

    @Override
    public void insertContact(@NonNull Contact contact, @NonNull InsertContactCallback insertContactCallback) {
        SQLiteDatabase sqLiteDatabase = mContactHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(ContactHelper.CONTACTS_COLUMN_NAME, contact.getname());
        contentValues.put(ContactHelper.CONTACTS_COLUMN_PHONE, contact.getphone());
        contentValues.put(ContactHelper.CONTACTS_COLUMN_EMAIL, contact.getemail());
        contentValues.put(ContactHelper.CONTACTS_COLUMN_STREET, contact.getstreet());
        contentValues.put(ContactHelper.CONTACTS_COLUMN_PLACE, contact.getplace());

        long returnValue = sqLiteDatabase.insert(ContactHelper.CONTACTS_TABLE_NAME, null, contentValues);

        if (returnValue == -1)
            insertContactCallback.onInsertFailed();
        else
            insertContactCallback.onInsertSuccess();
    }
}
