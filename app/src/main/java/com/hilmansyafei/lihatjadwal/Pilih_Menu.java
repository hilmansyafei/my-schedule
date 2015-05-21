package com.hilmansyafei.lihatjadwal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Hilman Syafei on 24/03/2015.
 */
public class Pilih_Menu extends ActionBarActivity {
    Intent intent = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    }
    public void Jad_kul(View view){
        Toast.makeText(getApplicationContext(),
                "Jadwal Kuliah", Toast.LENGTH_SHORT).show();
        intent = new Intent(getApplicationContext(),Input_data.class);
        intent.putExtra("menu", "kelas");
        intent.putExtra("title", "Kelas");
        startActivity(intent);
    }

    public void  Jad_dos(View view){
        Toast.makeText(getApplicationContext(),
                "Jadwal Dosen", Toast.LENGTH_SHORT).show();
        intent = new Intent(getApplicationContext(),Input_data.class);
        intent.putExtra("menu", "dosen");
        intent.putExtra("title", "Nama Dosen");
        startActivity(intent);
    }
    public void  kal_ak(View view){
        Toast.makeText(getApplicationContext(),
                "Kalender Akademik", Toast.LENGTH_SHORT).show();
    }
    public void  ujian(View view){
        Toast.makeText(getApplicationContext(),
                "Jadwal Ujian", Toast.LENGTH_SHORT).show();
        intent = new Intent(getApplicationContext(),Input_data.class);
        intent.putExtra("menu", "ujian");
        intent.putExtra("title", "Kelas");
        startActivity(intent);
    }
    public void  cek_nilai(View view){
        Toast.makeText(getApplicationContext(),
                "Cek Nilai", Toast.LENGTH_SHORT).show();
        intent = new Intent(getApplicationContext(),Cek_Nilai.class);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splahscreen, menu);
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

