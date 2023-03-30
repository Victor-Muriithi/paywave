package com.example.paywave;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.text.Layout;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;

import com.example.paywave.Services.Adapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Details> arrayList;
    RecyclerView RecyclerView;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView = findViewById(R.id.recyclerView);
        arrayList = new ArrayList<>();

        arrayList.add(new Details("Electricity", "234234234", "+254709876754", false));
        arrayList.add(new Details("Electricity", "234234234", "+254709876754", false));
        arrayList.add(new Details("Electricity", "234234234", "+254709876754", false));
        adapter = new Adapter(arrayList, MainActivity.this);
        RecyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, AddEditActivity.class);
                startActivity(i);


                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }
}