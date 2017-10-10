package com.example.sqlitedatabase.utils;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.sqlitedatabase.addcontact.datasource.AddContactRepository;
import com.example.sqlitedatabase.addcontact.datasource.local.AddContactLocalDataSource;
import com.example.sqlitedatabase.main.datasource.MainRepository;
import com.example.sqlitedatabase.main.datasource.local.MainLocalDataSource;

/**
 * Merupakan class yang digunakan untuk menginject repo
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 10 Oktober 2017
 */
public class Injection {

    /**
     * Method yang digunakan untuk menginject main repository
     *
     * @param context merupakan context dari activity
     * @return merupakan object main repository
     */
    public static MainRepository proviceMainRepository(@NonNull Context context) {
        return MainRepository.getInstance(MainLocalDataSource.getInstance(context));
    }

    /**
     * Method yang digunakan untuk menginject add contact repository
     *
     * @param context merupakan context dari activity
     * @return merupakan object main repository
     */
    public static AddContactRepository proviceAddContactRepository(@NonNull Context context) {
        return AddContactRepository.getInstance(AddContactLocalDataSource.getInstance(context));
    }
}
