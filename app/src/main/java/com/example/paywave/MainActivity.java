package com.example.paywave;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.telecom.Call;
import android.text.Layout;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;

import com.example.paywave.Services.Adapter;

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

//        // Create the dummy data
//        List<Details> dataList = new ArrayList<>();
//        dataList.add(new Details("John Smith", "1234567890"));
//        dataList.add(new Details("Jane Doe", "0987654321"));
//        dataList.add(new Details("Bob Johnson", "5555555555"));

// Create the adapter and set it for the RecyclerView
//        ListAdapter adapter = new ListAdapter(dataList);
//        RecyclerView recyclerView = findViewById(R.id.recyclerView);
//        recyclerView.setAdapter(adapter);


    }
}