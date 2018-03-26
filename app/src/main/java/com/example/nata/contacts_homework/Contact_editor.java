package com.example.nata.contacts_homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Contact_editor extends AppCompatActivity {

    EditText editName, editPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_editor);

        editName=findViewById(R.id.editName);
        editPhone=findViewById(R.id.editPhone);




    }
}
