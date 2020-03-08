package com.example.alonso_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder>{

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView deadlineName;
        public TextView deadlineDetails;

        public ViewHolder(View itemView) {
            super(itemView);

            deadlineName = (TextView) itemView.findViewById(R.id.task_name);
            deadlineDetails = (TextView) itemView.findViewById(R.id.task_details);
        }
    }

    private List<Task> mTask;

    public TaskAdapter(List<Task> task) {
        mTask = task;
    }

    @NonNull
    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View deadlineView = inflater.inflate(R.layout.item_task,parent,false);

        ViewHolder viewHolder = new ViewHolder(deadlineView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Task task = mTask.get(position);

        TextView deadlineName = viewHolder.deadlineName;
        deadlineName.setText(task.getName());

        TextView deadlineDetails = viewHolder.deadlineDetails;
        deadlineDetails.setText(task.getDetails());

    }


    @Override
    public int getItemCount() {return mTask.size();
    }


}
