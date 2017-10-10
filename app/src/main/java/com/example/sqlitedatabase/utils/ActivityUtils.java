package com.example.sqlitedatabase.utils;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Merupakan class yang mengatur apa apa saja yang dibutuhkan setiap activity
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 10 Oktober 2017
 */
public class ActivityUtils {

    /**
     * Method yang digunakan untuk menambahkan fragment ke dalam activity
     *
     * @param fragmentManager merupakan fragment manager dari activity yang memanggil
     * @param fragment merupakan fragment yang ingin ditambahkan
     * @param frameId merupakan id layout tempat fragment ditanam
     */
    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                             @NonNull Fragment fragment, int frameId) {
        fragmentManager.beginTransaction().add(frameId, fragment).commit();
    }

    /**
     * Method yang digunakan untuk mereplace fragment yang ada didalam activity dengan fragment lain
     *
     * @param fragmentManager merupakan fragment manager dari activity yang memanggil
     * @param fragment merupakan fragment yang ingin menggantikan fragment yang sudah ada
     * @param frameId merupakan id layout tempat fragment ditanam
     */
    public static void replaceFragmentOnActivity(@NonNull FragmentManager fragmentManager,
                                                 @NonNull Fragment fragment, int frameId) {
        fragmentManager.beginTransaction().replace(frameId, fragment).commit();
    }
}
