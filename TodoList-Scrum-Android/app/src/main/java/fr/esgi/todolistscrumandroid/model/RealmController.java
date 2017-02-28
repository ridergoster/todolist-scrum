package fr.esgi.todolistscrumandroid.model;

/**
 * Created by antoinepelletier on 28/02/2017.
 */

import android.content.Context;
import android.util.Log;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by mohsan on 27/07/16.
 */
public class RealmController {

    private static RealmController instance;
    private final Realm realm;

    public RealmController(Context context) {
        realm = Realm.getInstance(
                new RealmConfiguration.Builder(context)
                        .name("task.realm")
                        .build()
        );
    }

    public static RealmController getInstance(Context context) {

        if (instance == null) {
            instance = new RealmController(context);
        }
        return instance;
    }

    public Realm getRealm() {
        return realm;
    }



    //clear all objects from Book.class
    public void clearAll() {
        Log.e("Delete database", "Delete historique");
        realm.beginTransaction();
        realm.delete(Task.class);
        realm.commitTransaction();
    }

    //find all objects in the Book.class
    public RealmResults<Task> getAllTask() {

        return realm.where(Task.class).findAll();
    }

    //query a single item with the given id
    public Task getTask(String id) {

        return realm.where(Task.class).equalTo("id", id).findFirst();
    }

    //check if Book.class is empty
    public boolean hasVideo() {

        return !realm.where(Task.class).findAll().isEmpty();
    }

    //query example
    public RealmResults<Task> queryVideo() {

        return realm.where(Task.class)
                .contains("author", "Author")
                .or()
                .contains("title", "Realm")
                .findAll();

    }
}
