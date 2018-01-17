package com.example.angela.starwars.main;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.angela.starwars.elements.ElementsActivity;
import com.example.angela.starwars.R;

public class MainActivity extends AppCompatActivity {

    private Button accessButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
    }

    private void initUI() {
        accessButton = findViewById(R.id.accessButton);
        accessButton.setOnClickListener(onAccessButtonClicked);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private final View.OnClickListener onAccessButtonClicked = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            final Intent intent = ElementsActivity.getStartIntent(MainActivity.this);
            startActivity(intent);
        }
    };
}
