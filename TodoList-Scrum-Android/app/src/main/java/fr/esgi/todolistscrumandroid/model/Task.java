package fr.esgi.todolistscrumandroid.model;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.RealmObject;

/**
 * Created by ozone on 28/02/2017.
 */

public class Task extends RealmObject{

    private int id;
    private String title;
    private String description;

    public Task() {

    }

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    protected Task(Parcel in) {
        id = in.readInt();
        title = in.readString();
        description = in.readString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }
}
