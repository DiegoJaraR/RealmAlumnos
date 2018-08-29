package com.example.alumnoicin.realmalumnos.application;

import android.app.Application;

import com.example.alumnoicin.realmalumnos.models.alumno;
import java.util.concurrent.atomic.AtomicInteger;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;


public class MyApplication extends Application{

    public static AtomicInteger alumnoID = new AtomicInteger();

    @Override
    public void onCreate() {
        super.onCreate();
        // initialize Realm
        Realm.init(getApplicationContext());

        RealmConfiguration config = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
        Realm realm = Realm.getInstance(config);
        alumnoID = setAtomicId(realm, alumno.class);


        realm.close();
    }

    private <T extends RealmObject> AtomicInteger setAtomicId(Realm realm, Class<T> anyClass) {
        RealmResults<T> results = (RealmResults<T>) realm.where(anyClass).findAll();
        return (results.size() > 0) ? new AtomicInteger(results.max("id").intValue()) : new AtomicInteger();
    }
}
