package com.example.sqlitedatabase.base;

/**
 * Merupakan interface root dari presenter
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 10 Oktober 2017
 */
public interface BasePresenter {

    void onCreate();
    void onStart();
    void onResume();
    void onPause();
    void onStop();
    void onDestroy();
}
