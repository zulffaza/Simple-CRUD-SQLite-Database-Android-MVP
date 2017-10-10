package com.example.sqlitedatabase.base;

import android.support.annotation.NonNull;

/**
 * Merupakan interface root untuk view
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 10 Oktober 2017
 */
public interface BaseView<T> {

    void setPresenter(@NonNull T presenter);
}
