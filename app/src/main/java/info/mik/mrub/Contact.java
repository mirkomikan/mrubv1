package info.mik.mrub;

import android.net.Uri;

/**
 * Created by mik on 5/4/18.
 */

public class Contact {
    private String name;
    private String surname;
    private String phoneNumber;
    private String photoUri;

    public Contact(String name, String surname, String phoneNumber, String photoUri) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.photoUri = photoUri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhotoUri() {
        return photoUri;
    }

    public void setPhotoUri(String photoUri) {
        this.photoUri = photoUri;
    }
}
