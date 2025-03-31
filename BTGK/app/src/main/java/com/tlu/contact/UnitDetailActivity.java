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
import com.tlu.contact.model.Unit;

/**
 * Activity to display detailed information about a university unit
 */
public class UnitDetailActivity extends AppCompatActivity {

    private Unit unit;

    private TextView textName;
    private TextView textPhone;
    private TextView textAddress;
    private TextView textEmail;
    private TextView textWebsite;
    private TextView textDescription;

    private ImageView imgCall;
    private ImageView imgEmail;
    private ImageView imgWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_detail);

        // Setup toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Initialize UI components
        textName = findViewById(R.id.text_unit_detail_name);
        textPhone = findViewById(R.id.text_unit_detail_phone);
        textAddress = findViewById(R.id.text_unit_detail_address);
        textEmail = findViewById(R.id.text_unit_detail_email);
        textWebsite = findViewById(R.id.text_unit_detail_website);
        textDescription = findViewById(R.id.text_unit_detail_description);

        imgCall = findViewById(R.id.img_call);
        imgEmail = findViewById(R.id.img_email);
        imgWeb = findViewById(R.id.img_web);

        // Get the unit ID from the intent
        long unitId = getIntent().getLongExtra("UNIT_ID", -1);
        if (unitId != -1) {
            unit = ContactData.getUnitById(unitId);
            if (unit != null) {
                displayUnitDetails();
                setupActionButtons();
            } else {
                Toast.makeText(this, "Unit not found", Toast.LENGTH_SHORT).show();
                finish();
            }
        } else {
            Toast.makeText(this, "Invalid unit ID", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    /**
     * Display unit details in the UI
     */
    private void displayUnitDetails() {
        getSupportActionBar().setTitle(unit.getName());

        textName.setText(unit.getName());
        textPhone.setText(unit.getPhoneNumber());
        textAddress.setText(unit.getAddress());
        textEmail.setText(unit.getEmail());
        textWebsite.setText(unit.getWebsite());
        textDescription.setText(unit.getDescription());
    }

    /**
     * Setup action buttons for calling, emailing, and visiting website
     */
    private void setupActionButtons() {
        imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + unit.getPhoneNumber().replaceAll("\\s+", "")));
                startActivity(intent);
            }
        });

        imgEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:" + unit.getEmail()));
                startActivity(intent);
            }
        });

        imgWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(unit.getWebsite()));
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
