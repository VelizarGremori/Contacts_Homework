package com.example.nata.contacts_homework;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ContactsViewHolder> {

    private List<Contact> contacts;
    private Context context;

    public RVAdapter(List<Contact> contacts, Context context) {
        this.contacts = contacts;
        this.context = context;
    }



    public ContactsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.conteiner_rv, parent, false);
        return new ContactsViewHolder(view);
    }


    public void onBindViewHolder(final ContactsViewHolder holder, int position) {
        final Contact contact = contacts.get(position);

        holder.txtPhone.setText(String.valueOf(contact.getPhone()));
        holder.txtName.setText(contact.getName());
        holder.cvListener.setRecord(contact);

    }

    public int getItemCount() {
        return contacts.size();
    }

    class ContactsViewHolder extends RecyclerView.ViewHolder {

        TextView txtName, txtPhone;
        CardView cv;

        CardViewClickListener cvListener = new CardViewClickListener();

        ContactsViewHolder(View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txt_rv_name);
            txtPhone = itemView.findViewById(R.id.txt_rv_phone);
            cv = itemView.findViewById(R.id.cv_rv);

            cv.setOnClickListener(cvListener);


        }
    }

        class CardViewClickListener implements View.OnClickListener {
            Contact contact;

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, Contact_editor.class);
                intent.putExtra("test", true);
                intent.putExtra("id", contact.id);

                ((Activity) context).startActivity(intent);

            }
            void setRecord(Contact contact) {
                this.contact = contact;
            }

        }

}