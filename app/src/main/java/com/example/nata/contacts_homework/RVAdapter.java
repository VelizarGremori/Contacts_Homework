package com.example.nata.contacts_homework;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ContactsViewHolder> {

    private List<Contact> contacts;
    private Context context;

    public RVAdapter(List<Contact> contacts, Context context) {
        this.contacts = contacts;
        this.context = context;
    }



    public ContactsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.conteiner_rv, parent, false); // создаём вьюшку для кажого элемента
        return new ContactsViewHolder(view); //передаём вьюшку в качестве аргумента для холдера
    }


    public void onBindViewHolder(final ContactsViewHolder holder, int position) { //тут будет просходить обработка каждого элемента, кога он появится на экране
        final Contact film = contacts.get(position);// получаем элемент для удобства использования

        holder.txtPhone.setText(String.valueOf(film.getPhone())); // ставим дату для текстового поля с годом
        holder.txtName.setText(film.getName()); //ставим название года

    }

    public int getItemCount() {
        return contacts.size();
    }

    class ContactsViewHolder extends RecyclerView.ViewHolder {

        TextView txtName, txtPhone;
        CardView cv;

        //Инициализируем слушатели
        CardViewClickListener cvListener = new CardViewClickListener();

        ContactsViewHolder(View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txt_rv_name);
            txtPhone = itemView.findViewById(R.id.txt_rv_phone);
            cv = itemView.findViewById(R.id.cv_rv);

            //цепляем слушатели
            cv.setOnClickListener(cvListener);


        }
    }

        class CardViewClickListener implements View.OnClickListener {

            private Contact contact;

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, Contact_editor.class);
                intent.putExtra("test", true);

                ((Activity) context).startActivity(intent);

            Toast.makeText(context, "Я бы открыл новое окно для \"" +  "\" , но мне лень", Toast.LENGTH_SHORT).show();
            }
            void setRecord(Contact contact) {
                this.contact = contact;
            }

//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(context, Contact_editor.class);
//                intent.putExtra("test", true);
//                Toast.makeText(context, ""+i, Toast.LENGTH_SHORT).show();
        }

}