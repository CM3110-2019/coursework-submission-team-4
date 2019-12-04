package com.example.parkingprogram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import android.widget.Toast;

import com.example.parkingprogram.ui.Models.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;

public class MainActivity extends AppCompatActivity {


    Button btnSignIn, btnRegister;
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;

    ConstraintLayout root;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get button
        Button loginButton = findViewById(R.id.button11);

        // Get the animation from AnimationUtils and load it
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.button_animation);

        // Animate the TextViews
        loginButton.startAnimation(animation);

        loginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_SHORT).show();




            }
        });

        btnSignIn = findViewById(R.id.button11);
        btnRegister = findViewById(R.id.btnRegister);
        root = findViewById(R.id.root_element);
        auth =  FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRegisterWindow();

            }
        });


        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSignInWindow();

            }
        });
    }




    private void showSignInWindow(){

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Login");
        dialog.setMessage("Enter details");

        LayoutInflater inflater = LayoutInflater.from(this);
        View sign_in_Window = inflater.inflate(R.layout.sign_on_window, null);
        dialog.setView(sign_in_Window);

        final MaterialEditText email = sign_in_Window.findViewById(R.id.emailField);
        final MaterialEditText password = sign_in_Window.findViewById(R.id.PasswordField);

        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });


        dialog.setPositiveButton("Login", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(TextUtils.isEmpty(email.getText().toString())){

                    Snackbar.make(root, "Enter your email", Snackbar.LENGTH_SHORT).show();
                    return;

                }

                if(TextUtils.isEmpty(password.getText().toString())){

                    Snackbar.make(root, "Enter your password", Snackbar.LENGTH_SHORT).show();
                    return;

                }

                auth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                startActivity(new Intent(MainActivity.this, Pars.class));
                                finish();
                            }
                        }). addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Snackbar.make(root, "Error logging in." + e.getMessage(), Snackbar.LENGTH_SHORT).show();
                    }
                });

            }
        });

        dialog.show();

    }






    private void showRegisterWindow() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Register");
        dialog.setMessage("Enter details");

        LayoutInflater inflater = LayoutInflater.from(this);
        View registerWindow = inflater.inflate(R.layout.register_window, null);
        dialog.setView(registerWindow);

        final MaterialEditText email = registerWindow.findViewById(R.id.emailField);
        final MaterialEditText username = registerWindow.findViewById(R.id.usernameField);
        final MaterialEditText password = registerWindow.findViewById(R.id.PasswordField);
        final MaterialEditText carreg = registerWindow.findViewById(R.id.carField);

        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });


        dialog.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(TextUtils.isEmpty(email.getText().toString())){

                    Snackbar.make(root, "Enter your email", Snackbar.LENGTH_SHORT).show();
                    return;

                }
                if(TextUtils.isEmpty(username.getText().toString())){

                    Snackbar.make(root, "Enter your username", Snackbar.LENGTH_SHORT).show();
                    return;

                }
                if(TextUtils.isEmpty(password.getText().toString())){

                    Snackbar.make(root, "Enter your password", Snackbar.LENGTH_SHORT).show();
                    return;

                }
                if(TextUtils.isEmpty(carreg.getText().toString())){

                    Snackbar.make(root, "Enter your car registration number", Snackbar.LENGTH_SHORT).show();
                    return;

                }

                //register user
                auth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                User user = new User();
                                user.setEmail(email.getText().toString());
                                user.setPassword(password.getText().toString());
                                user.setCarreg(carreg.getText().toString());
                                user.setUsername(username.getText().toString());

                                users.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(user)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Snackbar.make(root, "User has been added", Snackbar.LENGTH_SHORT).show();
                                            }
                                        });
                            }
                        });
            }
        });

        dialog.show();


    }
}























