package com.example.recview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class KontakActivity extends AppCompatActivity {
    List<ContactModel> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontak);

        addData();
    }

    private void addData() {
        elements = new ArrayList<>();
        elements.add(new ContactModel("#46C8DA", "Arjuna", "08976574765", "Available"));
        elements.add(new ContactModel("#C5DA46", "Runi", "08976748765", "Available"));
        elements.add(new ContactModel("#DA4646", "Bob", "08976985765", "Not Available"));
        elements.add(new ContactModel("#9946DA", "Juna", "08540574765", "Available"));
        elements.add(new ContactModel("#98D696", "Juni", "08976583765", "Available"));
        elements.add(new ContactModel("#96D6D2", "Abdul", "08976914765", "Not Available"));
        elements.add(new ContactModel("#C596D6", "Rozak", "08988574765", "Available"));
        elements.add(new ContactModel("#D6AD96", "Andi", "08976570565", "Available"));
        elements.add(new ContactModel("#C9D696", "Sadewa", "08977874765", "Available"));
        elements.add(new ContactModel("#96A4D6", "Boni", "08976884765", "Not Available"));

        ContactAdapter adapter = new ContactAdapter(elements, this, new ContactAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ContactModel item) {
                detail(item);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.rvContact);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
    private void detail(ContactModel item) {
        Intent intent = new Intent(KontakActivity.this, DetailActivity.class);
        intent.putExtra("ContactModel", item);
        startActivity(intent);
    }
}