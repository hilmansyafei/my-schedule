package com.hilmansyafei.lihatjadwal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Hilman Syafei on 25/03/2015.
 */
public class Cek_Nilai extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }
    public void cek_nilai(View view) {
            Intent intent = new Intent(getApplicationContext(), List_Nilai.class);
            EditText user = (EditText) findViewById(R.id.user);
            String username = user.getText().toString();
            EditText pass = (EditText) findViewById(R.id.pass);
            String password = pass.getText().toString();

            //Toast.makeText(getApplicationContext(),
            //    " "+username+" "+password, Toast.LENGTH_SHORT).show();
            intent.putExtra("user", username);
            intent.putExtra("pass", password);
            startActivity(intent);

            user.setText("");
            pass.setText("");




    }
}
