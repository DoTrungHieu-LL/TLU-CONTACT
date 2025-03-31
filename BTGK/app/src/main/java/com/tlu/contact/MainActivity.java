package com.tlu.contact;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

/**
 * Main activity displaying the two main options for the app:
 * - Unit directory
 * - Staff directory
 */
public class MainActivity extends AppCompatActivity {

    private Button btnUnitDirectory;
    private Button btnStaffDirectory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.app_name);

        // Initialize UI components
        btnUnitDirectory = findViewById(R.id.btn_unit_directory);
        btnStaffDirectory = findViewById(R.id.btn_staff_directory);

        // Set click listeners
        btnUnitDirectory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch Unit Directory activity
                Intent intent = new Intent(MainActivity.this, UnitListActivity.class);
                startActivity(intent);
            }
        });

        btnStaffDirectory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch Staff Directory activity
                Intent intent = new Intent(MainActivity.this, StaffListActivity.class);
                startActivity(intent);
            }
        });
    }
}
