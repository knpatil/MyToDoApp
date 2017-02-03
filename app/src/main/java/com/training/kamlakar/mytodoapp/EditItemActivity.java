package com.training.kamlakar.mytodoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {
    EditText item;
    Integer editPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        String itemText = getIntent().getStringExtra("text");
        editPosition = getIntent().getIntExtra("position", 0);
        item = (EditText) findViewById(R.id.etEditText);
        item.setText(itemText);
        item.setSelection(item.getText().length());
    }

    public void onEditItem(View view) {
        // get edited value
        EditText editedText = (EditText) findViewById(R.id.etEditText);

        // prepare intent
        Intent data = new Intent();
        data.putExtra("EditedText", editedText.getText().toString());
        data.putExtra("code", 200);
        data.putExtra("position", editPosition);
        setResult(RESULT_OK, data);
        finish();
    }
}
