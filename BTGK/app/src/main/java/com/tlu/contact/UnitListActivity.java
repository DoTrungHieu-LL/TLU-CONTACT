package com.tlu.contact;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tlu.contact.adapter.UnitAdapter;
import com.tlu.contact.data.ContactData;
import com.tlu.contact.model.Unit;

import java.util.List;

/**
 * Activity to display a list of university units
 */
public class UnitListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UnitAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_list);

        // Setup toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.unit_directory);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recycler_units);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get unit data and setup adapter
        List<Unit> unitList = ContactData.getUnits();
        adapter = new UnitAdapter(this, unitList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
