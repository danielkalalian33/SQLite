package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyDatabaseHelper myDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDatabaseHelper = new MyDatabaseHelper(this);


    }
    public void register(View view)
    {
        EditText id = findViewById(R.id.id_);
        EditText name = findViewById(R.id.name_);
        EditText level = findViewById(R.id.level_);
        long check = myDatabaseHelper.insertRecord(id.getText().toString(), name.getText().toString(), Integer.parseInt(level.getText().toString()));
        if (check > -1){
        Toast.makeText(this, "added succesfully", Toast.LENGTH_LONG).show();}
        else {
            Toast.makeText(this, "oops fail hh", Toast.LENGTH_LONG).show();}


    }
    public void edit(View view)
    {

    }
    public void delete(View view)
    {

    }
    public void viewall(View view)
    {
        Cursor cursor = myDatabaseHelper.getAll();
        if (cursor.getCount() > 0)
        {
            StringBuffer buffer = new StringBuffer();
            while (cursor.moveToNext()){
                buffer.append("ID: " + cursor.getString(0) + "\n");
                buffer.append("Name: " + cursor.getString(1) + "\n");
                buffer.append("Level: " + cursor.getString(2) + "\n");
            }
            Toast.makeText(this, buffer, Toast.LENGTH_LONG).show();
        }
    }
}
