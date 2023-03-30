package com.example.paywave;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();


        TextView loginRedirect =findViewById(R.id.loginRedirect);
        Button signUpButton = findViewById(R.id.button);

        //email and sign up credentials
        TextView emailTextView = findViewById(R.id.editTextTextPersonName);
        TextView editTextTextPassword = findViewById(R.id.editTextTextPassword);
        TextView confirmPasswordTextView = findViewById(R.id.editTextTextPassword2);


        loginRedirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        //sign up button click listener
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(emailTextView.getText().length() == 0 || editTextTextPassword.getText().length() == 0 ||  confirmPasswordTextView.getText().length() == 0 ){
                    Toast.makeText(SignupActivity.this, "Enter the required fields",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                if(!editTextTextPassword.getText().toString().equals(confirmPasswordTextView.getText().toString())){
                    Toast.makeText(SignupActivity.this, "Password mismatch",
                            Toast.LENGTH_SHORT).show();
                    System.out.println(editTextTextPassword.getText().toString());
                    System.out.println(confirmPasswordTextView.getText().toString());
                    return;
                }

                createAccount(emailTextView.getText().toString(), editTextTextPassword.getText().toString());
            }
        });

    }
 // iamtestUser_2
    //Create account method
    private void createAccount(String email, String password) {
        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            // Sign in success, update UI with the signed-in user's information
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(SignupActivity.this, "createUserWithEmail:success",
                                    Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
//                            updateUI(user);

                            Intent i = new Intent(SignupActivity.this, MainActivity.class);
                            startActivity(i);


                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignupActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                    }
                });
        // [END create_user_with_email]
    }

    private void updateUI(FirebaseUser user) {
    }
}