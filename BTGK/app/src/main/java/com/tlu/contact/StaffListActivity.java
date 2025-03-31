package com.tlu.contact;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tlu.contact.adapter.StaffAdapter;
import com.tlu.contact.data.ContactData;
import com.tlu.contact.model.Staff;

import java.util.List;

/**
 * Activity to display a list of staff members
 */
public class StaffListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StaffAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_list);

        // Setup toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.staff_directory);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recycler_staff);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get staff data and setup adapter
        List<Staff> staffList = ContactData.getStaffList();
        adapter = new StaffAdapter(this, staffList);
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
