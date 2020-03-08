package com.example.alonso_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class BuatActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_buat);
    }
    public void onClick(View view) {
        Intent data = new Intent();
//---get the EditText view---
        EditText nameTask = (EditText)findViewById(R.id.editText2);
        EditText detailTask = (EditText)findViewById(R.id.editText);
//---set the data to pass back---
        String name = nameTask.getText().toString();
        String detail = detailTask.getText().toString();

        Bundle bundle = new Bundle();
        bundle.putString("aName",name);
        bundle.putString("aDetail",detail);

        data.putExtras(bundle);
        setResult(RESULT_OK, data);
//---closes the activity---
        finish();
    }
}
