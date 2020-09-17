package com.example.sharedpreference_activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button saveButton, viewButton;
    int count = 0;
    public static final String MYPREF = "mMPreference";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saveButton = findViewById(R.id.saveData);
        viewButton = findViewById(R.id.intent);
        sharedPreferences = getSharedPreferences(MYPREF, Context.MODE_PRIVATE);
        count = sharedPreferences.getInt("StoreCountValue", 0);

      /*  if (savedInstanceState != null) {
            count = savedInstanceState.getInt("current score");
        }*/
        saveData();
        clickToNewActivity();
    }

    public void saveData() {
        System.out.println("Before Data Store " + count);
        saveButton.setText("Current Data " + "\n" + count);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                saveButton.setText("after click" + count);
                System.out.println("Data Store " + count);
            }
        });
    }

    public void clickToNewActivity() {
        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("StoreCountValue", count);
                editor.commit();
                Toast.makeText(MainActivity.this, "Count value store Succesfully", Toast.LENGTH_LONG).show();
            }
        });
    }

    /*@Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        System.out.println(">>> Inside onStop");
        outState.putInt("current score", count);
    }*/

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println(">>>>> inside onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println(">>>>> inside onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println(">>>>> inside onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println(">>>>> inside onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println(">>>>> inside onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println(">>>>> inside onDestroy");
    }
}