package com.example.sqlitedatabase.main.contract;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;

import com.example.sqlitedatabase.base.BasePresenter;
import com.example.sqlitedatabase.base.BaseView;
import com.example.sqlitedatabase.main.model.Contact;

import java.util.List;

/**
 * Merupakan contract yang mengatur hubungan antara presenter dan view pada main
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 10 Oktober 2017
 */
public interface MainContract {

    interface View extends BaseView<Presenter> {

        void showContacts();
        void showContactMenu(@NonNull Contact contact, @NonNull android.view.View view);
        void updateDeletedContacts(@NonNull Contact contact);
        void showAddContact();
        void showAddUserMessage(@NonNull String message);
    }

    interface Presenter extends BasePresenter {

        void loadContacs(@NonNull List users);
        void openContactMenu(@NonNull Contact contact, @NonNull android.view.View view);
        void editContact(@NonNull Contact contact);
        void deleteContact(@NonNull Contact contact);
        void openAddContact();
        void resultAddContact(@NonNull Integer requestCode, @NonNull Integer resultCode,
                              @NonNull Intent data);
    }
}
