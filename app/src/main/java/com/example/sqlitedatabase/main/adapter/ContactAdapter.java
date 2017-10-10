package com.example.sqlitedatabase.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sqlitedatabase.R;
import com.example.sqlitedatabase.main.contract.MainContract;
import com.example.sqlitedatabase.main.model.Contact;
import com.example.sqlitedatabase.main.viewholder.ContactViewHolder;

import java.util.ArrayList;

/**
 * Merupakan adapter yang mengatur recycler view untuk menampilkan list contact
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 10 Oktober 2017
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private ArrayList<Contact> mContacts;
    private Context mContext;
    private LayoutInflater mInflater;
    private MainContract.Presenter mPresenter;

    public ContactAdapter(Context context, ArrayList<Contact> contacts, MainContract.Presenter presenter) {
        mContacts = contacts;
        mContext = context;
        mPresenter = presenter;

        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row_contact, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        Contact contact = mContacts.get(position);

        ImageView ivMenu = holder.getivMenu();
        TextView tvName = holder.gettvName();
        TextView tvPhone = holder.gettvPhone();

        tvName.setText(contact.getname());
        tvPhone.setText(contact.getphone());
        ivMenu.setOnClickListener(new OnMenuClickListener(contact, ivMenu));
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    private class OnMenuClickListener implements View.OnClickListener {

        private Contact mContact;
        private ImageView mIvMenu;

        private OnMenuClickListener(Contact contact, ImageView ivMenu) {
            mContact = contact;
            mIvMenu = ivMenu;
        }

        @Override
        public void onClick(View v) {
            mPresenter.openContactMenu(mContact, mIvMenu);
        }
    }
}
