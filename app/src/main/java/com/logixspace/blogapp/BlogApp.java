package com.logixspace.blogapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BlogApp extends AppCompatActivity {
    AppCompatButton b1,b2,b3,b4;
    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_blog_app);
        b1=(AppCompatButton) findViewById(R.id.logout);
        b2=(AppCompatButton) findViewById(R.id.search);
        b3=(AppCompatButton) findViewById(R.id.view);
        b4=(AppCompatButton) findViewById(R.id.delete);
        e1=(EditText) findViewById(R.id.post);
        e2=(EditText) findViewById(R.id.title);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences p = getSharedPreferences("Log",MODE_PRIVATE);
                SharedPreferences.Editor editor = p.edit();
                editor.clear();
                editor.apply();
                Intent i=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"Searching...",Toast.LENGTH_LONG).show();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String post=e1.getText().toString();
                String title=e2.getText().toString();
                Toast.makeText(getApplicationContext(),post+" "+title+" "+"icon",Toast.LENGTH_LONG).show();            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"Deleting...",Toast.LENGTH_LONG).show();
            }
        });
    }
}