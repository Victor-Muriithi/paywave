package com.example.signuploginrealtime;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

public class AddEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);

        // Populate the spinner
        Spinner spinner = findViewById(R.id.type_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        TextInputEditText entityNameField = findViewById(R.id.entity_name);
        TextInputEditText phoneEditText = findViewById(R.id.phone);
        TextInputEditText accountEditText = findViewById(R.id.account);
        TextInputEditText payBillEditText = findViewById(R.id.paybill);

        Button saveButton = findViewById(R.id.save_action);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String entityName = entityNameField.getText().toString();
                String selectedType = spinner.getSelectedItem().toString();
                String phoneString = phoneEditText.getText().toString();
                int phone = Integer.parseInt(phoneString);
                String account = accountEditText.getText().toString();
                String payBill = payBillEditText.getText().toString();

                Map<String, Object> details = new HashMap<>();
                details.put("name", entityName);
                details.put("category", selectedType);
                details.put("phone", phone);
                details.put("account", account);

                db.collection("user").document("details")
                        .set(details)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d(TAG, "DocumentSnapshot successfully written!");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error writing document", e);
                            }
                        });
            }
        });

    }
}