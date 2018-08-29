package com.example.alumnoicin.realmalumnos.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.alumnoicin.realmalumnos.R;
import com.example.alumnoicin.realmalumnos.adapters.MyAdapters;
import com.example.alumnoicin.realmalumnos.models.alumno;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity implements RealmChangeListener<RealmResults<alumno>> {

    private GridView gridView;
    private MyAdapters adapter;

    private Realm realm;
    private RealmResults<alumno> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm.init(getApplicationContext());
        realm = Realm.getDefaultInstance();
        gridView = (GridView) findViewById(R.id.gridView);

        people = getAllPeople();
        people.addChangeListener(this);

        adapter = new MyAdapters(people, R.layout.grid_item_view, this);

        gridView.setAdapter(adapter);
    }



    @Override
    public void onChange(RealmResults<alumno> element) {
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        realm.removeAllChangeListeners();
        realm.close();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item_add:
                addPeople();
                return true;
            case R.id.item_delete:
                removeAll();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private RealmResults<alumno> getAllPeople() {
        return realm.where(alumno.class).findAll();
    }

    private void removeAll() {
        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();
    }



    private void addPeople() {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                      //  Toast.makeText(getApplicationContext(),"hola",Toast.LENGTH_SHORT).show();

                alumno p1 = new alumno("22222222-2", "Diego","Jara",22,"icin",1121,"segundo");
                alumno p2 = new alumno("33333333-3", "Diego","Jara",22,"icin",1123,"segundo");
                alumno p3 = new alumno("44444444-4", "Diego","Jara",22,"icin",1123,"segundo");
                alumno p4 = new alumno("55555555-5", "Diego","Jara",22,"icin",1123,"segundo");
                alumno p5 = new alumno("66666666-6", "Diego","Jara",22,"icin",1123,"segundo");
                alumno p6 = new alumno("77777777-7", "Diego","Jara",22,"icin",1123,"segundo");
                alumno p7 = new alumno("88888888-8", "Diego","Jara",22,"icin",1123,"segundo");
                alumno p8 = new alumno("99999999-9", "Diego","Jara",22,"icin",1123,"segundo");
                alumno p9 = new alumno("00000000-0", "Diego","Jara",22,"icin",1123,"segundo");
                alumno p10 = new alumno("11111111-1", "Diego","Jara",22,"icin",1123,"segundo");




                realm.copyToRealmOrUpdate(p1);
                realm.copyToRealmOrUpdate(p2);
                realm.copyToRealmOrUpdate(p3);
                realm.copyToRealmOrUpdate(p4);
                realm.copyToRealmOrUpdate(p5);
                realm.copyToRealmOrUpdate(p6);
                realm.copyToRealmOrUpdate(p7);
                realm.copyToRealmOrUpdate(p8);
                realm.copyToRealmOrUpdate(p9);
                realm.copyToRealmOrUpdate(p10);


                people = getAllPeople();
            }
        });
    }
}
