package com.mvpdemo.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.mvpdemo.R;
import com.mvpdemo.datamodel.College;
import com.mvpdemo.interfaces.OnViewClick;

import java.util.ArrayList;

public class CollegeAdapter extends RecyclerView.Adapter<CollegeAdapter.CollegeViewHolder> implements Filterable {
    private ArrayList<College> collegeArrayList;
    private ArrayList<College> filtered;
    private OnViewClick onViewClick;

    public CollegeAdapter(ArrayList<College> collegeArrayList, OnViewClick onViewClick) {
        this.collegeArrayList = collegeArrayList;
        this.filtered = collegeArrayList;
        this.onViewClick = onViewClick;
    }

    @NonNull
    @Override
    public CollegeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_row_college, parent,false);
        return new CollegeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CollegeViewHolder holder, int position) {
        holder.tvCollegeId.setText(""+filtered.get(position).getId());
        holder.tvCollegeName.setText(filtered.get(position).getName());
        holder.tvCollegeCourse.setText(filtered.get(position).getCoursesAvailable());
    }

    @Override
    public int getItemCount() {
        if(filtered != null){
            return filtered.size();
        }
        return 0;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    filtered = collegeArrayList;
                } else {
                    ArrayList<College> filteredList = new ArrayList<>();
                    for (College row : collegeArrayList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or course number match
                        if (row.getName().toLowerCase().contains(charString.toLowerCase()) || row.getCoursesAvailable().toLowerCase().contains(charString.toLowerCase()) ) {
                            filteredList.add(row);
                        }
                    }

                    filtered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filtered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filtered = (ArrayList<College>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    class CollegeViewHolder extends RecyclerView.ViewHolder {
        TextView tvCollegeId, tvCollegeName, tvCollegeCourse;
            public CollegeViewHolder(View itemView) {
            super(itemView);
            tvCollegeId = itemView.findViewById(R.id.tv_college_id);
            tvCollegeName = itemView.findViewById(R.id.tv_college_name);
            tvCollegeCourse = itemView.findViewById(R.id.tv_college_course);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onViewClick.onItemClick(v, getAdapterPosition());
                }
            });
        }
    }
}
