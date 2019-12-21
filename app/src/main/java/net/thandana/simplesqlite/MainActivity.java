package net.thandana.simplesqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btn_store, btn_get;
    private EditText et_name;
    private DbHelper dbHelper;
    private TextView tv_names;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DbHelper(this);
        tv_names = (TextView) findViewById(R.id.tv_names);

        btn_store = (Button) findViewById(R.id.btn_store);
        btn_get = (Button) findViewById(R.id.btn_get);
        et_name = (EditText) findViewById(R.id.et_name);

        btn_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.addStudentDetail(et_name.getText().toString());
                et_name.setText("");
                Toast.makeText(MainActivity.this, "Stored Your Name Successfully!", Toast.LENGTH_SHORT).show();
            }
        });

        btn_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList = dbHelper.getAllStudentsList();
                tv_names.setText("");
                for (int i = 0; i < arrayList.size(); i++){
                    tv_names.setText(tv_names.getText().toString()+", " + arrayList.get(i));
                }
            }
        });
    }
}