package com.example.sqlitedatabase.main.model;

/**
 * Merupakan model dari user yang akan disimpan
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 10 Oktober 2017
 */
public class Contact {

    private int mId;
    private String mName;
    private String mPhone;
    private String mEmail;
    private String mStreet;
    private String mPlace;

    public Contact() {
        this(null, null, null, null, null);
    }

    public Contact(String name, String phone, String email, String street, String place) {
        this(0, name, phone, email, street, place);
    }

    public Contact(int id, String name, String phone, String email, String street, String place) {
        mId = id;
        mName = name;
        mPhone = phone;
        mEmail = email;
        mStreet = street;
        mPlace = place;
    }

    public int getid() {
        return mId;
    }

    public void setid(int id) {
        mId = id;
    }

    public String getname() {
        return mName;
    }

    public void setname(String name) {
        mName = name;
    }

    public String getphone() {
        return mPhone;
    }

    public void setphone(String phone) {
        mPhone = phone;
    }

    public String getemail() {
        return mEmail;
    }

    public void setemail(String email) {
        mEmail = email;
    }

    public String getstreet() {
        return mStreet;
    }

    public void setstreet(String street) {
        mStreet = street;
    }

    public String getplace() {
        return mPlace;
    }

    public void setplace(String place) {
        mPlace = place;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Contact) {
            Contact contact = (Contact) obj;
            int id = contact.getid();

            if (id != 0)
                return id == mId;
            else
                return contact.getname().equals(mName);
        } else
            return false;
    }
}
