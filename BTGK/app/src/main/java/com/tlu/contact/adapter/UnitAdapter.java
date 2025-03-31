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
import com.tlu.contact.UnitDetailActivity;
import com.tlu.contact.model.Unit;

import java.util.List;

/**
 * Adapter for displaying units in a RecyclerView
 */
public class UnitAdapter extends RecyclerView.Adapter<UnitAdapter.UnitViewHolder> {

    private List<Unit> unitList;
    private Context context;

    public UnitAdapter(Context context, List<Unit> unitList) {
        this.context = context;
        this.unitList = unitList;
    }

    @NonNull
    @Override
    public UnitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_unit, parent, false);
        return new UnitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UnitViewHolder holder, int position) {
        Unit unit = unitList.get(position);
        holder.textName.setText(unit.getName());
        holder.textPhone.setText(unit.getPhoneNumber());

        // Set click listener to open the detail activity
        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UnitDetailActivity.class);
                intent.putExtra("UNIT_ID", unit.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return unitList.size();
    }

    /**
     * ViewHolder class for unit items
     */
    public static class UnitViewHolder extends RecyclerView.ViewHolder {
        TextView textName;
        TextView textPhone;
        ConstraintLayout layoutItem;

        public UnitViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.text_unit_name);
            textPhone = itemView.findViewById(R.id.text_unit_phone);
            layoutItem = itemView.findViewById(R.id.layout_unit_item);
        }
    }
}
