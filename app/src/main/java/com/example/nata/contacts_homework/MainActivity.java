package com.example.nata.contacts_homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Contact> contacts;


        ContactsHelper ch= new ContactsHelper(getApplicationContext());

        ch.insert("Name1","Phone1");


        contacts=ch.getAll();

        rv = findViewById(R.id.rv);

        rv.setLayoutManager(new LinearLayoutManager(this)); // устанавливаем разметку для списка.
        rv.setItemAnimator(new DefaultItemAnimator()); //устанавливаем класс, отвечающий за анимации в списке
        rv.setAdapter(new RVAdapter(contacts,this)); //устанавливаем наш адаптер

    }
}
