package com.example.paywave;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;

import com.example.paywave.Services.Adapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

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

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        if(uid == null){
            Intent i = new Intent(MainActivity.this, AddEditActivity.class);
            startActivity(i);
        }

        RecyclerView = findViewById(R.id.recyclerView);
        arrayList = new ArrayList<>();
//        adapter = new Adapter(arrayList, MainActivity.this);

        db.collection("user")
                .document(uid)
                .collection("details")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                arrayList.add(new Details(document.get("entity").toString(),document.get("payBill").toString() , document.get("accountNumber").toString(),false ));
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                        adapter = new Adapter(arrayList, MainActivity.this);

                        RecyclerView.setLayoutManager(new LinearLayoutManager( MainActivity.this));

                        RecyclerView.setAdapter(adapter);

                        adapter.notifyDataSetChanged();

                    }
                });




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

//        usersRef.get().addOnCompleteListener(task -> {
//            if (task.isSuccessful()) {
//                List<User> usersList = new ArrayList<>();
//                for (QueryDocumentSnapshot document : task.getResult()) {
//                    User user = document.toObject(User.class);
//                    usersList.add(user);
//                }
//                UsersAdapter adapter = new UsersAdapter(usersList);
//                recyclerView.setAdapter(adapter);
//            } else {
//                Log.d(TAG, "Error getting documents: ", task.getException());
//            }
//        });
    }
}