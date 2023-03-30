package com.example.signuploginrealtime;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
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
        Button cancelButton = findViewById(R.id.cancel_button);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        // Set up OnClickListener for cancel button
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set text of each TextInputEditText to be blank
                entityNameField.setText("");
                phoneEditText.setText("");
                accountEditText.setText("");
                payBillEditText.setText("");
            }
        });

        String entityName = entityNameField.getText().toString();
        String selectedType = spinner.getSelectedItem().toString();
        String phoneString = phoneEditText.getText().toString();
        int phone = 0; // default value in case phoneEditText is empty
        if (!TextUtils.isEmpty(phoneString)) {
            phone = Integer.parseInt(phoneString);
        }
        String account = accountEditText.getText().toString();
        String payBill = payBillEditText.getText().toString();

        int finalPhone = phone;
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Details details = new Details("",entityName, selectedType, phoneString,
                        account, payBill);

                // Create a new document with a randomly generated ID
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String uid = user.getUid();

                db.collection("user")
                        .document(uid)
                        .collection("details")
                        .add(details)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d(TAG, "DocumentSnapshot written with ID: " + documentReference.getId());
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error adding document", e);
                            }
                        });

            }
        });

    }
}