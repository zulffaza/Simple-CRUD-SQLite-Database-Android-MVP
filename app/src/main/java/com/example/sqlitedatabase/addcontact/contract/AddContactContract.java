package com.example.sqlitedatabase.addcontact.contract;

import android.support.annotation.NonNull;

import com.example.sqlitedatabase.base.BasePresenter;
import com.example.sqlitedatabase.base.BaseView;
import com.example.sqlitedatabase.main.model.Contact;

/**
 * Merupakan contract yang mengatur hubungan antara view dan presenter pada add contract
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 10 Oktober 2017
 */
public interface AddContactContract {

    interface View extends BaseView<Presenter> {

        void showNameEmpty();
        void hideNameEmpty();
        void showProgressDialog();
        void hideProgressDialog();
        void finishView(@NonNull String message);
    }

    interface Presenter extends BasePresenter {

        void saveContact(@NonNull Contact contact);
    }
}
