package com.example.paywave;

import static com.example.paywave.R.id.SecondFragment;
import static com.example.paywave.R.id.pie_chart;
import static com.github.mikephil.charting.utils.ColorTemplate.*;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Reports_page extends AppCompatActivity {

    private PieChart piechart;
    private ArrayList<String> category_list;
    private ArrayList<Float> price_list;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reports_page);


        category_list = new ArrayList<String>();
        category_list.add("Utilities");
        category_list.add("Clothes");
        category_list.add("Rent");
        category_list.add("food");
        category_list.add("Others");


        price_list = new ArrayList<Float>();
        price_list.add((float)7000.00);
        price_list.add((float)4000.00);
        price_list.add((float)8200.00);
        price_list.add((float)6400.00);
        price_list.add((float)11650.00);




        piechart = findViewById(pie_chart);
        //Initialize Array list
        ArrayList<PieEntry> pie_entries = new ArrayList<>();

            int j = category_list.size() - 1;
        for (int i=0; i<=j; i++ ){

            //insert data to one entry
            String category = (String) category_list.get(i);
            Float price = (Float) price_list.get(i);


            PieEntry pieEntry = new PieEntry(price, category);
            //insert the entry data into the array list
            pie_entries.add(pieEntry);

        }

        PieDataSet pie_data_set = new PieDataSet(pie_entries, "Categories");

        pie_data_set.setColors(COLORFUL_COLORS);

        piechart.setData(new PieData(pie_data_set));

        piechart.animateXY(2500, 2500);

        piechart.getDescription().setEnabled(false);



    }
}