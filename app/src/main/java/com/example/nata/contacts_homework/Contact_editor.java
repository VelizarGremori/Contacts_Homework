package com.example.nata.contacts_homework;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Contact_editor extends AppCompatActivity {

    EditText editName, editPhone;
    Button button;
    boolean test;
    Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_editor);

        editName=findViewById(R.id.editName);
        editPhone=findViewById(R.id.editPhone);
        button=findViewById(R.id.button_for_edit);

        test = (boolean) getIntent().getSerializableExtra("test");
        if (test){
            button.setText("Изменить");
            contact = (Contact) getIntent().getSerializableExtra("Contact");
        }else {
            button.setText("Добавить");
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ContactsHelper ch = new ContactsHelper(getApplicationContext());
                if (test){
                    ch.update((long)getIntent().getSerializableExtra("id"), editName.getText().toString(), editPhone.getText().toString());
                }else {
                    ch.insert(editName.getText().toString(), editPhone.getText().toString());
                }



                finish();
            }
        });







    }
}
