package com.example.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recyclerview.R;
import com.example.recyclerview.model.Contact;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    private List<Contact> ListContact = new ArrayList<>();

    public ContactAdapter(List<Contact> ListContact) {
        this.ListContact = ListContact;
    }

    private OnContactClickListener Listener;

    public interface OnContactClickListener {
        public void OnClick(View view,int position);
    }
    public void setListener(OnContactClickListener Listener){
        this.Listener = Listener;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View vh = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_contact,viewGroup,false);
        ContactViewHolder viewHolder = new ContactViewHolder(vh);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ContactViewHolder holder, int i) {
     Contact item = ListContact.get(i);
     ContactViewHolder.txtPhone.setText(item.getPhone());
     ContactViewHolder.txtName.setText(item.getName());

    }

    @Override
    public int getItemCount() {
        return ListContact.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageContact;
        public static TextView txtName;
        public static TextView txtPhone;

        public ContactViewHolder(@NonNull final View itemView) {
            super(itemView);
            imageContact = itemView.findViewById(R.id.imageContact);
            txtName = itemView.findViewById(R.id.txtName);
            txtPhone = itemView.findViewById(R.id.txtPhone);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Listener.OnClick(v, getAdapterPosition());
                }
            });
        }
    }

    private class Picasso {
    }
}
