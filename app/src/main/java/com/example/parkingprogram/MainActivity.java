package com.example.parkingprogram;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    Button btnSignIn, btnRegister;
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;



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



    }
}
