package com.example.alonso_app;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Task> task;
    String aName;
    String aDetail;
    TaskAdapter adapter;

    Intent data = new Intent("com.example.alonso_app.BuatActivity");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView rvTask = (RecyclerView)findViewById(R.id.rvTask);

        task = Task.createTaskList(2);

        adapter = new TaskAdapter(task);

        rvTask.setAdapter(adapter);
        rvTask.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(data,1);
//                task.add(new Task("PPL1","Tugas Refactor"));
//                adapter.notifyDataSetChanged();
//
//
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                aName = data.getStringExtra("aName");
                aDetail = data.getStringExtra("aDetail");
                Toast.makeText(this, "Task berhasil ditambah", Toast.LENGTH_LONG).show();
//                Toast.makeText(this, DetailFromIntent1, Toast.LENGTH_LONG).show();
//                Toast.makeText(this, DateFromIntent1, Toast.LENGTH_LONG).show();
                //deadlineArrayList.add(new Deadline(NameFromIntent1,DetailFromIntent1,DateFromIntent1));
                task.add(new Task(aName,aDetail));
            }
        }
        adapter.notifyDataSetChanged();
        super.onActivityResult(requestCode,resultCode,data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
