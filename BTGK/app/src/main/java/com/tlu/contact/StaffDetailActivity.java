package com.tlu.contact;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.tlu.contact.data.ContactData;
import com.tlu.contact.model.Staff;

/**
 * Activity to display detailed information about a staff member
 */
public class StaffDetailActivity extends AppCompatActivity {

    private Staff staff;

    private TextView textName;
    private TextView textPosition;
    private TextView textUnit;
    private TextView textPhone;
    private TextView textEmail;
    private TextView textOffice;

    private ImageView imgCall;
    private ImageView imgEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_detail);

        // Setup toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Initialize UI components
        textName = findViewById(R.id.text_staff_detail_name);
        textPosition = findViewById(R.id.text_staff_detail_position);
        textUnit = findViewById(R.id.text_staff_detail_unit);
        textPhone = findViewById(R.id.text_staff_detail_phone);
        textEmail = findViewById(R.id.text_staff_detail_email);
        textOffice = findViewById(R.id.text_staff_detail_office);

        imgCall = findViewById(R.id.img_call_staff);
        imgEmail = findViewById(R.id.img_email_staff);

        // Get the staff ID from the intent
        long staffId = getIntent().getLongExtra("STAFF_ID", -1);
        if (staffId != -1) {
            staff = ContactData.getStaffById(staffId);
            if (staff != null) {
                displayStaffDetails();
                setupActionButtons();
            } else {
                Toast.makeText(this, "Staff not found", Toast.LENGTH_SHORT).show();
                finish();
            }
        } else {
            Toast.makeText(this, "Invalid staff ID", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    /**
     * Display staff details in the UI
     */
    private void displayStaffDetails() {
        getSupportActionBar().setTitle(staff.getName());

        textName.setText(staff.getName());
        textPosition.setText(staff.getPosition());
        textUnit.setText(staff.getUnit());
        textPhone.setText(staff.getPhoneNumber());
        textEmail.setText(staff.getEmail());
        textOffice.setText(staff.getOffice());
    }

    /**
     * Setup action buttons for calling and emailing
     */
    private void setupActionButtons() {
        imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + staff.getPhoneNumber().replaceAll("\\s+", "")));
                startActivity(intent);
            }
        });

        imgEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:" + staff.getEmail()));
                startActivity(intent);
            }
        });
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
