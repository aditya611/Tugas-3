package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.recyclerview.adapter.ContactAdapter;
import com.example.recyclerview.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public RecyclerView rv;
    public ContactAdapter contactAdapter;
    public RecyclerView.LayoutManager layoutManager;
    public List<Contact> ListContact = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.imageContact);
        ListContact.add(new Contact("Iron Man",
                "102018308",
                "https://cdn4.iconfinder.com/data/icons/famous-characters-add-on-vol-1-flat/48/Famous_Character_-_Add_On_1-14-512.png"));

        ListContact.add(new Contact("Bat Man",
                "102018309",
                "https://cdn4.iconfinder.com/data/icons/famous-characters-add-on-vol-1-flat/48/Famous_Character_-_Add_On_1-22-512.png"));

        ListContact.add(new Contact("Groot",
                "102018307",
                "https://cdn4.iconfinder.com/data/icons/famous-characters-add-on-vol-1-flat/48/Famous_Character_-_Add_On_1-21-512.png"));

        ListContact.add(new Contact("Sonic",
                "102018301",
                "https://cdn4.iconfinder.com/data/icons/famous-characters-add-on-vol-1-flat/48/Famous_Character_-_Add_On_1-26-512.png"));


        contactAdapter = new ContactAdapter(ListContact);
        contactAdapter.setListener((ContactAdapter.OnContactClickListener) this);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setAdapter(contactAdapter);
        rv.setLayoutManager(layoutManager);
    }


}