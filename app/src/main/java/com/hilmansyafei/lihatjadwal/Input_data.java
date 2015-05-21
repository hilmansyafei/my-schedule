package com.hilmansyafei.lihatjadwal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Hilman Syafei on 24/03/2015.
 */
public class Input_data extends ActionBarActivity {
    String menu;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_data);
        Intent i = this.getIntent();
        menu = i.getStringExtra("menu");
        title = i.getStringExtra("title");

        TextView myAwesomeTextView = (TextView)findViewById(R.id.textView);
        myAwesomeTextView.setText("Masukan "+title);

    }
    public void cek_jad(View view) {
       // Toast toast = Toast.makeText(getApplicationContext(),"asiiik ", Toast.LENGTH_SHORT);
        //toast.show();
        EditText text = (EditText) findViewById(R.id.editText);
        String cek = text.getText().toString();
        if(cek!="") {
            if (menu.equals("ujian")) {
                Intent intent = new Intent(getApplicationContext(), List_ujian.class);
                EditText editText = (EditText) findViewById(R.id.editText);
                String message = editText.getText().toString();
                intent.putExtra("kelas", message);
                intent.putExtra("menu", menu);
                startActivity(intent);
            } else {
                Intent intent = new Intent(getApplicationContext(), LIst_Jadwal.class);
                EditText editText = (EditText) findViewById(R.id.editText);
                String message = editText.getText().toString();
                intent.putExtra("kelas", message);
                intent.putExtra("menu", menu);
                startActivity(intent);
            }
        }
    }
}
