package com.tlu.contact.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.tlu.contact.R;
import com.tlu.contact.StaffDetailActivity;
import com.tlu.contact.model.Staff;

import java.util.List;

/**
 * Adapter for displaying staff members in a RecyclerView
 */
public class StaffAdapter extends RecyclerView.Adapter<StaffAdapter.StaffViewHolder> {

    private List<Staff> staffList;
    private Context context;

    public StaffAdapter(Context context, List<Staff> staffList) {
        this.context = context;
        this.staffList = staffList;
    }

    @NonNull
    @Override
    public StaffViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_staff, parent, false);
        return new StaffViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StaffViewHolder holder, int position) {
        Staff staff = staffList.get(position);
        holder.textName.setText(staff.getName());
        holder.textPosition.setText(staff.getPosition());
        holder.textUnit.setText(staff.getUnit());

        // Set click listener to open the detail activity
        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, StaffDetailActivity.class);
                intent.putExtra("STAFF_ID", staff.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return staffList.size();
    }

    /**
     * ViewHolder class for staff items
     */
    public static class StaffViewHolder extends RecyclerView.ViewHolder {
        TextView textName;
        TextView textPosition;
        TextView textUnit;
        ConstraintLayout layoutItem;

        public StaffViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.text_staff_name);
            textPosition = itemView.findViewById(R.id.text_staff_position);
            textUnit = itemView.findViewById(R.id.text_staff_unit);
            layoutItem = itemView.findViewById(R.id.layout_staff_item);
        }
    }
}
